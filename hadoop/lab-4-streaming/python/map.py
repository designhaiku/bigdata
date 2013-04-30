#!/usr/bin/env python

import string;
import sys;

map = {};
for rec in sys.stdin.readlines():
    cols = string.split(rec);
    for colval in cols:
        if colval in map:
            map[colval] = map[colval] + 1;
        else:
            map[colval] = 1;

## mini reducer / combiner
for k in map:
    val = str(map[k]);
    print str(k) + '\t' + str(val);

