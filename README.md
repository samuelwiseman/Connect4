# Connect4

This project is a command line version of the well known game Connect4

## Getting Started

To start the game first you must compile the Connect4.java using the command: 

```bash
javac Connect4.java
```
Then to play, you simply run the same file using the following command:

```bash
java Connect4.java
```

If you wish to edit the players in the game, you can do so by instantiating a new player in the same file. 

Either

```java
gamecontroller.addPlayer(new HumanPlayer('R', 'Human Player 1'));
```

Or

```java
gamecontroller.addPlayer(new ComputerPlayer('R', 'Computer Player 1'));
```

With the first parameter being the token of choice for that player, and the second being the player's name.

