#!/bin/bash 

python ./metodo-euler.py \
&& \
echo -e "\n" && \
gcc ./code.c -o exe && \
./exe \
&& \
echo -e "\n" && \
cd ./java/ && \
./run.sh
