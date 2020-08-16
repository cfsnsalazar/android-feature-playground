#!/bin/bash

BASEDIR=$(dirname "$0")

echo "Module name:"

read moduleName

echo "Where module is located?:"

read moduleLocation

mkdir -p $moduleLocation/$moduleName

#Create build.gradle file in module
cp $BASEDIR/build.gradle $moduleLocation/$moduleName/build.gradle

#Create base src folder in module
mkdir -p $moduleLocation/$moduleName/src/main/kotlin

#Create a AndroidManifest in module
cp $BASEDIR/AndroidManifest.xml $moduleLocation/$moduleName/src/main/AndroidManifest.xml
#Add the given module name to package name in androidManifest
sed -i "s/moduleName/$moduleLocation.$moduleName/" $moduleLocation/$moduleName/src/main/AndroidManifest.xml

#Create .gitignore file in module
cp $BASEDIR/.gitignore $moduleLocation/$moduleName/.gitignore

#Add module to settings.gradle
if [ "$moduleLocation" = "." ]; then
  echo "Remember add Module :$moduleName to settings.gradle"
else
  echo "Remember add Module :$moduleLocation:$moduleName to settings.gradle"
fi

#Add new module .gitinore file to git, this command avoid new build folder be versioned
git add "$moduleLocation/$moduleName/.gitignore"
echo "File $moduleLocation/$moduleName/.gitignore added to git"
