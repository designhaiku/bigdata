# This script can be executed from  hbase shell
# At least that is the intention

# The intention is to ilustrate simple HBase commands

#create a table (table name -> play, column family -> games)

create 'play', 'games'

#see what tables we have in HBase
list #or list 'tablename'
#see what the table looks like.
describe 'play'

#let's put some data into the table
put 'play', 'game1', 'games:name', 'My Very first game!'
put 'play', 'game1', 'games:name', 'My second game'
put 'play', 'game2', 'games:name', 'My magic game'

#now let look at the data
get 'play', 'game1' #play with other get options

#question: hbase stores multiple versions automatically. How do we retrieve an older option?

#scan a table
scan 'play'
#maybe not a very brilliant idea. What about scanning given a range. How do we do that?

#count rows - also not a really good idea
count 'play'

#now I want to delete this. Need to disable first
disable 'play'
drop_all 'play'

#great job - we just went in circle

# Now some homework

#Original table had a single column family

# create a table with multiple families
# alter table to allow unlimited number of versions for each family
#alter 'play', { NAME => 'games', VERSIONS => org.apache.hadoop.hbase.HConstants::ALL_VERSIONS }

#look at the HFiles. Notice something interesing?

# add data to this table. Add a row that has multiple columns
# oops! hbase shell only allows one column at a time - not that great.
# Let's fix this. Open the put_multi_columns.rb script and play with it


