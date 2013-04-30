#!/usr/bin/env python

import string;
import sys;
colnum = -1;
sum = 0;
map = {};
for rec in sys.stdin:
    cols = string.split(rec)
    key = cols[0]
    val = int(cols[1])
    if key in map:
        map[key] = map[key] + val
    else:
        map[key] = val

for k in map:
    val = str(map[k])
    print str(k) + '\t' + str(val)
