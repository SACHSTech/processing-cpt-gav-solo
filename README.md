[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7919176&assignment_repo_type=AssignmentRepo)

# Program Title: Catch The Notes!

Introduction: 
"Catch The Notes!" can loosely be classified as a rhythm game. In this game there are three songs to select from,
which are: "Made In Love", "Renatus", and "Everything Will Freeeze", with the difficulty of each subsequent level being progressively harder. 

Goals / Scoring: 
The objective of the game is to catch the notes (circles) that are mapped to the song falling from the top of the screen. For each note caught, score is awarded to the player and accuracy is calculated, with the score being calculated by dividing 1 million by the note count of the song and the accuracy being the ratio between the notes caught and the total notes displayed thus far. Additionally, accuracy is a percentage value - calculated by dividing the notes caught, from the notes fallen - that decides the 'rank' of the player, which is shown at the result screen. Having an accuracy of above 95% gives the player an 'S' rank, with each subsequent accuracy range being shown below.

90-95%: A Rank
85-90%: B Rank
<85%: C rank

This means that ultimately, the goal of the game is survive through the song without failing, and achieve a score as close to 100% and a million score as possible. 

Gameplay Mechanics: 

When first loaded into the game, the user is introduced to the menu screen where they have labeled buttons to select the song they want to play. After the song is selected, the player will then be loaded into the song screen where a user controlled bowl is used to catch the falling notes. To move the bowl to the left, the user will use the 'a' key and to move the user to the right the 'd' key is used. To move the bowl at double the default speed, the user can hold down the spacebar. If the user misses to many subsequent notes without catching any, the player will be loaded to the fail screen where they can retry the song or return to the main menu. The score and accuracy of the player is kept at the top right and left of the screen respectively, and a red bar denoting the player's health and a blue bar denoting the player's progress through the song is at the top of the screen. To pause the game the player can simply press 'p', where they will be loaded to a screen where they can either resume the song, retry the song, or return to the main menu. If the user completes the song level, the user will be loaded to a result screen, where they will be able to view their final score, accuracy, and rank, and return to the main menu. 

Limitations:
Some limitations of the game include only having three songs to choose from to play. Additionally, the users "combo" count when catching multiple notes in a row, is only present for cosmetic purposes and does not affect the users score at all. Another limitation may be that there is no physical button to pause the game, instead relying only on the 'p' key on the keyboard. 



