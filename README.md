# Rack-Up-Grades!!

This is a single-player game with a time limit and a leaderboard. We took inspiration from the classic carnival game Whack-A-Mole and digitalized it. 
The goal of the game remains the same. The player's main goal is to hit the mole however the specific rules change between the three levels provided: Easy, Medium, and Hard.

  The Easy level is meant to be almost a tutorial for how the game works at the basic level. The player needs to click the moles as they appear and they just accumulate points as time goes by.
  The Medium Level takes it a bit further by adding the rule that missing a mole means a certain amount of points is deducted from your overall score. 
  The Hard Level is the master level where not only do the 2 rules above apply but we have an additional bomb where clicking that will also result in deduction of points. 

  As the user finishes playing the game, the game prompts them with a message if they would like to add their score to the leaderboard. If they choose yes then they can enter their name and depending on whether or not they place within the top 10, their scores will be displayed on the leaderboard. This leaderboard can also be accessed in the main menu

## Checklist For Your Project
- [ ] Verify if you are on the right branch and/or fetch the updated main 
- [ ] Discuss, Discuss, Discuss! Especially with teammates on what needs to get done and sort them out
- [ ] Branches have already been created so start working on your feature!
- [ ] When faced with a challenge meet up with teammates to discuss solutions before you ask the instructors.
- [ ] Use pull requests to merge finished features into the main branch
- [ ] Conduct code reviews and don't forget to add Javadocs


## Special design structures

There are many interesting design decisions we had to make during this project and few of them have led to interesting and special design structures. 
The file directory is compatible with any operating system that works with Java. 


## Design Patterns

We decided to use 2 design patterns in our work: Adapter and Facade

- Adapter: The problem that the adapter solves is the use of the third-party file format might break the code and introduce dependencies if we don't put another layer of abstraction on top of it. We do this in our project when we are outputting the results of the leaderboard from the file to the JTable UI through the use case and the Leaderboard output boundary (called InterfaceLeaderboardPresenter). This allowed us to make sure that any computer that used a txt file and had Java JTable set up could output the leaderboard without changing code. 

- Facade: The facade layer was set up in the Input Boundary Implementation class in the use case level because we saw that in order to add data to the leaderboard after a game we needed to do multiple things; get their name through UI, get their score from the use case and get the entire leaderboard from the database(in order to know where to put our score). This facade made sure that the user is not calling three different methods to get the job done but just one which gets all of it done. 


## Unit Testing

The tests we have made cover: test what happens if there are 10 ppl on the leaderboard but you want to add your score which is lower than all of theirs.
- Test Facade: to see if the design pattern has been implemented correctly and in the correct place as well.
- Test 



## Scenario Walk-Throughs
Provided is a visual representation of the key features of our game at the console level. 

