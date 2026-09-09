# Lab 2 - Chess Piece Move Validator

----------

## Project Overview
The purpose of this project is to validate legal chess moves for user-selected pieces and coordinates without using inheritance.

### Technical Information
### Files Needed
Main.java

PieceType.java
Chessboard.java
Rook.java
Queen.java

Pawn.java
Knight.java
Bishop.java
King.java

----------

### Attributes
* `private String piece_name;`
* `private String color;`
* `private char column;`
* `private int row;`

----------

### Constructors & Methods
* `public [PieceName]()` (Empty constructor)
* `public [PieceName](String color, char column, int row)` (Constructor with parameters)
* `public String getPieceName()`
* `public String getColor()`
* `public String getColumn()`
* `public String getRow()`
* `public void setColumn(char column)`
* `public void setRow(int row)`
* `public boolean verifyTarget(char targetColumn, int targetRow)`

----------

#### Tasks
| Team Member | Assigned Files |
| :--- | :---|
| **Diana** | 
| **Andres** |
| **Pamela** |

----------

## Git
We suggest creating feature branches for the assigned tasks, for example:
* `git checkout -b pamela/*nameofbranch`
* `git checkout -b andres/*nameofbranch`
* `git checkout -b diana/*nameofbranch`
Then, push each branch and open a pull request against `main` and make sure all files compile together before merging.