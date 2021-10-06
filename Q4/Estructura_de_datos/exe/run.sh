#!/bin/bash

if [[ "$1" == "hanoi" ]]
then
	echo "Going classes:"
	cd ../classes/
	echo -e "$PWD\nCompresing jar"
	jar cfmv ../exe/hanoi/hanoi.jar ../exe/hanoi/manifest.txt ./hanoi
	echo "Completed"
	exit 0
fi
