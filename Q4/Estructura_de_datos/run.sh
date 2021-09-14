#!/bin/bash

compile(){
	javac -d ./classes/ ./src/$1
}

run(){
	java -cp ./classes/ $1
}

compile $1
run $1
