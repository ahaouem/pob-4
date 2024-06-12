#!/bin/bash

cd src || exit
exercises=($(ls -d ex*))
cd ..

for exercise in ${exercises[@]}; do
    echo "Running tests for $exercise..."
    cd src/$exercise || exit
    mkdir -p out
    javac -d out $(ls | grep -v Test.java$ | grep .java$)
    javac -d out -cp out:../../junit-platform-console-standalone-1.3.1.jar *Test.java
    java -jar ../../junit-platform-console-standalone-1.3.1.jar --class-path out --scan-class-path
    cd ../..
done