#!/usr/local/bin/python3

__author__ = 'Sarvdeep Singh Bindra'


try:
    fh=open("xlines.txt")
    for line in fh.readlines():
        print(line)

except IOError as e:
    print("File not found({})".format(e))

print("Oops")