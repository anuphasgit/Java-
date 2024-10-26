# Project 5: MineWalker

Author: Anup Bhattarai
Class: CS121 Section 1
Semester: Spring 2023

# Overview
This java application implements a MineWalker game. The game consists of a game grid of hidden tiles, some of which consists mines. The game starts in the top left corner and the objective is to reach the bottom right corner of the grid. The game is over if you step on a tile with mine for five times.

# Reflection
I really enjoyed doing this project. I thought the project would be very challenging due to the GUI component that we had recently learned in class but it turned out to be fun and easy while doing it. I was able to find the errors and fix it as they arose since I had started working on the project early. However, I found an issue where the current mine position would dissappear when I stepped on a mine, and only reappear when I clicked on neighbouring mines. It was because of a line that set the text to nothing and a simple logic inside one of the if statements. While it was an easy fix, I only realized it near the end and was a bit stressing. It was altogether a great learning experience and the most interestinng project.

# Compiling and Using
To compile the program, run the folling command in the project folder:

$ javac MineWalker.java

To run the program,run :

$ java MineWalker

After running the program a game window will appear in the screen and you can start playing the game right away. Your goal is to reach the bottom right corner of the game grid while stepping on less than five mines. You can move through the game grid either left, right,up, and down. The tile you are currently on will be marked by X. The game grid has different color tiles representing different number of mine neighbors which you can refer from the color key chart. You are allowed to backtrack to the tiles you have stepped on. Once you complete the game setting 10 percent mines, try setting the mine percent higher and try completing the game. Have Fun Playing.

