#!/usr/bin/env ruby

#streaming does not agrregate values by key so we have to do that
#ourselves. Also need to keep track of totals for the key
current_key = nil
key_total = 0

STDIN.each_line do |line|
	(key,value) = line.split(/\t/)

    #have to set the key very first time 
    if(!current_key)
       current_key = key
    end	

	#check if we encountered a new key
	if(current_key && key != current_key && key_total > 0)
		puts current_key + "\t" + key_total.to_s
		#reset key and value
		current_key = key
		key_total = 0
	end
	
	key_total += value.to_i	

end

if(current_key)
   	puts current_key + "\t" + key_total.to_s
end

