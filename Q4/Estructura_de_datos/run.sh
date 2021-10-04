#!/bin/bash

compile(){
	echo "Compile:$1"
	javac -d ./classes/ ./src/$1/*
	echo "Compiled"
}

execute(){
	echo "Executing:$1"
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
	echo "Selecting:"
	select class in $(ls -1 ./classes/$1 | grep -i "prueba*")
	do
		execute ${1}.${class%.class} 
	done
}

if [[ "$1" == "hanoi" ]]
then
	echo "Compiling..."
	javac -d ./classes/ ./src/hanoi/*
	echo "Exec:"
	java -cp ./classes/ hanoi.Main
	exit 0
fi

selectProject
