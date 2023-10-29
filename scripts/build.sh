#!/bin/bash

../gradlew build -b ../build.gradle

if ! [ $# -eq 0 ] ; then
  echo "This script does not take any arguments"
  echo ""
  echo "Usage: ./compile.sh"
  echo ""
  echo "Nevertheless ,the project still compiled"
  echo $#
  exit 0
fi