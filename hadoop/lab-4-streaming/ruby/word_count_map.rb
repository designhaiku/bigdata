#!/usr/bin/env ruby

STDIN.each_line do |line|
   line.split(" ").each do |word|
       puts "#{word}\t1"
    end
end       

