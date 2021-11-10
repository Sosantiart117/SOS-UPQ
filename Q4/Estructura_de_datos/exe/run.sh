#!/bin/bash

compress(){
	echo "Going classes:"
	cd ../classes/
	echo -e "$PWD\nCompresing jar"
	jar cfmv ../exe/$1/$1.jar ../exe/$1/manifest.txt ./$1
	echo "Completed"
}

if [[ "$1" == "hanoi" ]]
then
	compress hanoi
	exit 0
elif [[ "$1" == "rockola" ]]
then
	compress rockola
	exit 0
elif [[ "$1" == "atm" ]]
then
	compress atm
	exit 0
fi

echo -e "slect a project: \n hanoi \n rockola"
