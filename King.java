public class King{
    // all of the attributes of the King piece
    private String piece_name;
    private String color;
    private char column;
    private int row;

    // Empty constructor
    public King(){
        this.piece_name = PieceType.KING.name();
        this.color = "White";
        this.column = 'A';
        this.row = 1;
    }

    // Constructor with parameters
    public King(String piece_name, String color, char column, int row){
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

        // Makes sure the King actually moves
        if (columnDifference == 0 && rowDifference == 0) {
            return false;
        }

        // Checks if move is valid
        if (columnDifference <= 1 && rowDifference <= 1) {
            return true;
        }
        return false;
    }



}