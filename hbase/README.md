## HBase Overview

### Motivation for NoSql
 * Classic architecture uses a relational database shared by multiple applications. The database acts as a persistence, concurency control and integration mechanism. There are several problems with this approach.
 * One alternative is to raise the level of abstraction and do integration at the service layer - hello SOA! SOA makes the underlying database irrelevant. We can pick the best tool for the job!
 * Another problem is the impedance mismatch between relational world and object oriented world. Some domains are really hard to express in relational terms.
 * Perhaps the major driving force behind the NoSql movement is the rise of the Cloud and the need to scale to gazillions of users. Relational databases are not particularly cloud friendly and are very expensive to scale.

### Types of NoSql databases
 Can be classified across several dimensions. I'll classify them by their data model. In Domain Drived Design an aggregate is a collection of related objects treated as one unit. We typically use aggregates to define atomic operations, consistency checks and communicate with the data storage. This approach nicely removes a signinficant part of the complexity associated with ORM tools. Aggregate orientation also makes scalability easier to tackle. The NoSql databases I will discuss use an aggregate oriented approach.

#### Key-Value databases

 Pretty much a key and anything you want as a value. Access the aggregate by key.

 **Examples:** Amazon Dynamo, Project Voldemort (OS implementation of Dynamo), Riak, Redis, MemcachedDB.

 **Use cases:** store session information, user profiles, things that can be tied to an id such as shopping cart data.

 **Don't use:** transactions across aggregates, query by some attribute inside the value, model relationships across aggregates.

#### Column-family databases
 It is pretty much a two level map. Rows are made of a bunch of columns that in turn belong to column families. Can access the entire row, or parts of it

 **Examples:** Big Table, HBase, Cassandra

 **Use cases:** Event logging, CMS, blogging, expiring usage

 **Don't use:** transactions accross aggregates, ad-hoc data access patterns

#### Document oriented databases
 Can see structure inside the aggregate.Can query by aggregate fields, return partial document and index.

 **Examples:** MongoDb, CouchDB

 **Use cases:** Event logging, CMS, Blogging, Web analytics, Real-time analytics (can have derived info in the document, and new metrics can be added without schema changes)

 **Don't use:** complex transactions across aggregates, complex ad-hoc query needs.


### Back to HBase
* Inspired by Google's BigTable paper (2006)
* Part of Hadoop ecosystem. Provides real-time data access and scales to massive amounts of data.

#### Building blocks

* The basic building block is a **column**. Each column may have multiple versions, with each value contained in a **cell**.
* Each cell is timestamped, versions are stored in decreasing value of their timestamp. Timestamps can be user specified. Can be constrained by predicate deletions e.g. only keep last 3 versions (default) or delete values older than one week.
* Multiple columns form a **row**. A row may contain millions of columns. Rows are stored lexicographically by their row keys.
* A **table** is a collection of rows.
* Columns are grouped into **column families**. Column families provide semantic boundaries between data. Columns from same family are stored together in the same storage file called an **HFile**
* Column families are defined at table creation time. Should not be changed too often since this is an expensive operation. Should have a reasonable number of families.
* The **Region** is the basic unit of scalability and load balancing. They represent continuous ranges of rows stored together - similar to shards in RDMS. Regions are dynamically created by the system. Can be either split when they become two large or merged to reduce number of storage files.
* Each region is served by exactly one **Region Server**. Each Region Server can serve multiple regions.

#### Storage
* Data stored in files called HFiles
* Persistent and ordered immutable maps from key to value
* Implemented as a sequence of blocks with an index at the end. This index is kept in memory. Lookup can be done with a single disk seek. Once the block with the lookup key is found, the block is read to find the actual key.
* Many filesystems are supported. Typically HFiles are stored in HDFS.

#### Writing data
* Data is written first to a commit log called WAL (write ahead log)
* Then is moved into memory in the memstore. Data is sorted in memstore.
* When memstore exceeds a certain threshold it is flushed to an HFile.

#### Data deletion
* HFiles are immutable so it is a bit convoluted.
* Data is marked for deletion first. During the read process marked data is skiped.
* Data is really deleted during the compaction process.

#### Read data
* Need to merge memstore with HFile

#### Compactions
* New HFile created each time memstore is flushed. End up with lots of files.
* Minor compaction - rewrites small HFiles into larger HFiles. Uses n-merge.
* Major compaction - rewrites all files within a column family or region. Drops deleted data, performs predicated deletion.

#### Master Node
* assigns regions to region servers using ZooKeeper
* handles load balancing
* holds metadata

#### Region Servers
* handle reads and writes
* handle region splitting

#### API
* now the fun begions. Start lab one and experiment!!!