public class Knight{
    // all of the attributes of the Knight piece
    private String piece_name;
    private String color;
    private char column;
    private int row;

    // Empty constructor
    public Knight(){
        this.piece_name = PieceType.KNIGHT.name();
        this.color = "White";
        this.column = 'A';
        this.row = 1;
    }

    // Constructor with parameters
    public Knight(String piece_name, String color, char column, int row){
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
        int columnDifference = Math.abs(targetColumn - this.column);
        int rowDifference = Math.abs(targetRow - this.row);
        
        // Check if it moves at all
        if (columnDifference == 0 && rowDifference == 0) {
            return false;
        }
        // Checks if it moves in an L shape
        if ((columnDifference == 2 && rowDifference ==1) || (columnDifference == 1 && rowDifference == 2)) {
            return true;
        }
        return false;
    }



}