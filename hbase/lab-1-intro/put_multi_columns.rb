import 'org.apache.hadoop.hbase.client.HTable'
import 'org.apache.hadoop.hbase.client.Put'

def java_bytes( *args )
  args.map { |arg| arg.to_s.to_java_bytes }
end

table = HTable.new( @hbase.configuration, "play" )

# think of this like starting a transaction. In fact HBase has transaction behavior
# at the row level
p = Put.new( *java_bytes( "game1" ) )

p.add( *java_bytes( "games", "name", "My magic game" ) )
p.add( *java_bytes( "games", "description", "Game big kids play" ) )
p.add( *java_bytes( "players", "name", "Joe Doe" ) )

#this is like commiting the transaction
table.put( p )