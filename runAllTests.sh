#!/bin/bash

## Excersie 1
echo "Running tests for ex1..."
cd src/ex1 || exit
mkdir -p out
javac -d out TextAnalysis.java
javac -d out -cp out:../../junit-platform-console-standalone-1.3.1.jar TextAnalysisTest.java
java -jar ../../junit-platform-console-standalone-1.3.1.jar --class-path out --scan-class-path
cd ../..

## Excersie 2
echo "Running tests for ex2..."
cd src/ex2 || exit
mkdir -p out
javac -d out User.java UserAnalyzer.java
javac -d out -cp out:../../junit-platform-console-standalone-1.3.1.jar UserAnalyzerTest.java
java -jar ../../junit-platform-console-standalone-1.3.1.jar --class-path out --scan-class-path
cd ../..

## Excersie 3
echo "Running tests for ex3..."
cd src/ex3 || exit
mkdir -p out
javac -d out Product.java ProductRepository.java
javac -d out -cp out:../../junit-platform-console-standalone-1.3.1.jar ProductRepositoryTest.java
java -jar ../../junit-platform-console-standalone-1.3.1.jar --class-path out --scan-class-path
cd ../..