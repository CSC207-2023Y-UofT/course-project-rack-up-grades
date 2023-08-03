# Rack-Up-Grades

This is a single-player game with a time limit and a leaderboard. We took inspiration from the classic carnival game Whack-A-Mole and digitalized it. 
The goal of the game remains the same. The player's main goal is to hit the mole however the specific rules change between the three levels provided: Easy, Medium, and Hard.

The Easy level is meant to be almost a tutorial for how the game works at the basic level. The player needs to click the moles as they appear and they just accumulate points as time goes by.
The Medium Level takes it a bit further by adding the rule that missing a mole means a certain amount of points is deducted from your overall score. 
The Hard Level is the master level where not only do the 2 rules above apply but we have an additional bomb where clicking that will also result in deduction of points. 

As the user finishes playing the game, the game prompts them with a message if they would like to add their score to the leaderboard. If they choose yes then they can enter their name and depending on whether or not they place within the top 10, their scores will be displayed on the leaderboard. This leaderboard can also be accessed in the main menu

## Checklist For Your Project
- [ ] Verify if you are on the right branch and/or fetch the updated main 
- [ ] Discuss, Discuss, Discuss! Specially with teammates on what needs to get done and sort them out
- [ ] Branches have already been created so start working on your feature!
- [ ] When faced with a challenge meet up with teammates to discuss solutions before you ask the instructors.
- [ ] Use pull requests to merge finished features into main branch
- [ ] Conduct code reviews and don't forget to add Javadocs

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

## Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
