Drawing Tool developed in Java


This archive contains a Java project of CS5001 practical 4 and relevant JUnit tests.
This project apply GuiDelegate structure, which combines view and controller together.



<1>Project structure
============================
1. All source code can be found in /src directory. 
 
2. Model source code can be found in /src/model package.

3. View source code can be found in /src/guiDelegate package.
 
4. JUnit tests can be found in /src/tests package.

5. Main method locats in /src/main package.



<2>Implemented features
=============================
1. This program support drawing multiple shapes, including Line, Rectangle, Ellipse, Cross, Triangle, Hexagons, Square and Circle.

2. This program support undo/redo users' drawing and clear all users' drawing.
    Once you click "clear" button, all shapes that created before will be deleted.

3. This program support color choosing. Users can select color in side bar. More colors can be found in clicking "Color" button. 

4. This program support filling function, which can fill shapes.
    Click "Fill" button before drawing the filled shape.



<3>Instructions for running this project in Windows
===============================
1. Enter the terminal.

2. Change to the CS5001-p4-vectordrawing directory.

3. Change to src directory

4. Compile all source code

  javac model/*.java guiDelegate/*.java main/*.java

5. Run this project

  java main/DrawingMain



<4>Instructions for running JUnit tests in Windows
===============================
1. Enter the terminal.

2. Change to the CS5001-p4-vectordrawing directory.

3. Compile JUnit tests

  javac -cp .\src\junit.jar;.\src\hamcrest.jar;.\src\;. src\tests\*.java

4. Run JUnit tests

  java -cp .\src\junit.jar;.\src\hamcrest.jar;.\src\;. org.junit.runner.JUnitCore tests.ModelTests
