#!/bin/bash

compile(){
	javac -d ./classes/ ./src/$1/*
}

execute(){
	java -cp ./classes/ $1
}

selectProject(){
	select dir in $(ls ./src/)
	do
		compile $dir
		selectExec $dir
	done
}

selectExec(){
	select class in $(ls -1 ./classes/$1 | grep -i "prueba*")
	do
		execute ${1}.${class%.class} 
	done
}

selectProject
