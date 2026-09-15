public class Pawn{
    // all of the attributes of the pawn piece
    private String piece_name;
    private String color;
    private char column;
    private int row;

    // Empty constructor
    public Pawn(){
        this.piece_name = PieceType.PAWN.name();
        this.color = "White";
        this.column = 'A';
        this.row = 1;
    }

    // Constructor with parameters
    public Pawn(String piece_name, String color, char column, int row){
        this.piece_name = piece_name;
        this.color = color;
        this.column = column;
        this.row = row;
    }
    // Getters 

    public String getColor() {
        return color;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    // Setters

    public void setColumn(char column) {
        this.column = column;
    }

    public void setRow(int row){
        this.row = row;

    }
    

    //Methods

    public boolean verifyTarget(char targetColumn, int targetRow) {
        // Checks to see pawn moved straight forward and not sideways
        if (targetColumn != this.column) {
            return false;
        }
        // We check the color of pawn to determine if it is moving forward or backward
        if (this.color.equalsIgnoreCase("White")) {

            // White pawns can only move forward (up the board)
            if (targetRow == this.row + 1) {
                return true;
            }
        } else if (this.color.equalsIgnoreCase("Black")) {
            
            // Black pawns can only move forward (down the board)
            if (targetRow == this.row - 1) {
                return true;
            }
        }
        return false;


    }



}