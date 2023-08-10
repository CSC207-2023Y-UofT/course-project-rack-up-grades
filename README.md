# Rack-Up-Grades!!

This is a single-player game with a time limit and a leaderboard. We took inspiration from the classic carnival game Whack-A-Mole and digitalized it into a game anyone can play. 
The goal of the game remains the same. The player's main goal is to hit the mole as quickly as possible, however, the specific rules change between the three levels provided: Easy, Medium, and Hard.

  The Easy level is meant to be almost a tutorial for how the game works at the basic level. The player needs to click the moles as they appear and they just accumulate points as time goes by. Moles do not appear very quickly, and points cannot be deducted no matter what, meaning the user does not have to worry about misclicking or clicking too slowly. 
  The Medium Level takes it a bit further by adding the rule that missing a mole means a certain amount of points is deducted from your overall score. The moles also appear faster, allowing for the opportunity for more points but also at the risk of losing points. 
  The Hard Level is the master level where not only do the 2 rules above apply but we have an additional bomb when clicking that will also result in the deduction of points. The bomb is intended to throw off the user, especially because the moles appear faster than in easy and medium, forcing the user to pay attention. 

  As the user finishes playing the game, the game prompts them with a message if they would like to add their score to the leaderboard. If they choose yes then they can enter their name and depending on whether or not they place within the top 10, their scores will be displayed on the leaderboard. If their score is in the top 10, it will be placed respectively where it belongs. If not, the leaderboard stays the same. This leaderboard can also be accessed in the main menu.

## Checklist For Your Project
- [ ] Verify if you are on the right branch and/or fetch the updated main 
- [ ] Discuss, Discuss, Discuss! Especially with teammates on what needs to get done and sort them out
- [ ] Branches have already been created so start working on your feature!
- [ ] When faced with a challenge, meet up with teammates to discuss solutions before you ask the instructors.
- [ ] Use pull requests to merge finished features into the main branch
- [ ] Conduct code reviews and don't forget to add Javadocs


## Special design structures

There are many interesting design decisions we had to make during this project and few of them have led to interesting and special design structures. 
The file directory is compatible with any operating system that works with Java. 


## Design Patterns

We decided to use 2 design patterns in our work: Adapter and Facade

Adapter: The problem that the adapter solves is the use of the third-party file format might break the code and introduce dependencies if we don't put another layer of abstraction on top of it. We do this in our project when we are outputting the results of the leaderboard from the file to the JTable through the use case and the Leaderboard output boundary (called InterfaceLeaderboardPresenter). This was because our program's persistent data reading produces an ArrayList of string, which JTable required a 2d array for our use case.

Facade: The facade layer was set up in the inputBoundaryImpl class in the application business layer because we saw that in order to add data to the leaderboard after a game we needed to do multiple things; get and set the user name, call a method to write to our file, read and update the presenter. This facade makes sure that we are not calling three different methods to get the job done but just one which gets all of it done.


## Unit Testing

The tests we have made cover: test what happens if there are 10 ppl on the leaderboard but you want to add your score which is lower than all of theirs. In this case, the score should not be added to the leaderboard, as only the top 10 scores should be added. In addition, if the leaderboard is not full of users (there are less than 10 entries), any new score should be added by default, until there are 10 entries, which then any new score will be compared and added if necessary. Also, other tests include: clicking on 5 items in a simulation of the game and clicking on all items at one position in a simulation of the game. This test the EasyUseCase and the controllers as well. Because the UseCases are so similar we have decided to omit the test for Medium and Hard as they work similarly. We also test lower-level programs in our CA to make sure the entities work. 

## Accessibility
Size and space for approach and use: 
One of the accessibility features we implemented was larger buttons, which satisfy the size and space for approach and use. Larger buttons allow users to have an easier time to click, making the game easier to practice and understand for beginners. The background is also simple, while the pictures for moles are contrasted and vibrant, along with large buttons, allowing the user to see the buttons easily, especially for those with visual impairment. 

Flexibility in use:
Another accessibility feature we implemented was the file system for the leaderboard and pictures. No matter the device, the leaderboard and pictures works on all java supporting operating systems, as it considers the file separator used by the OS and current running directory, and is therefore able to retrieve the file and write to it.

![im1](https://github.com/CSC207-2023Y-UofT/course-project-rack-up-grades/assets/122108416/3854a4ef-aadd-4de3-99ca-0452e49bd99d)
![im2](https://github.com/CSC207-2023Y-UofT/course-project-rack-up-grades/assets/122108416/567f0c1f-1309-4f8e-a636-c9aedad4766d)
![im3](https://github.com/CSC207-2023Y-UofT/course-project-rack-up-grades/assets/122108416/f8dce544-9146-4e5c-8068-e806a8f456c0)

## Scenario Walk-Throughs
Provided is a visual representation of the key features of our game in the console level. 

https://scontent.xx.fbcdn.net/v/t1.15752-9/356965009_986311105750773_4892014696163980439_n.jpg?stp=dst-jpg_s403x403&_nc_cat=103&ccb=1-7&_nc_sid=aee45a&_nc_ohc=42yoU3VwfeAAX8rmhBZ&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AdQEXMcVqSZ8r8dxCpyNM_F5wEd8hfY9Fidw3KlvYeXvGw&oe=64F602D9
