public class Bishop{
    // all of the attributes of the Bishop piece
    private String piece_name;
    private String color;
    private char column;
    private int row;

    // Empty constructor
    public Bishop(){
        this.piece_name = PieceType.BISHOP.name();
        this.color = "White";
        this.column = 'A';
        this.row = 1;
    }

    // Constructor with parameters
    public Bishop(String piece_name, String color, char column, int row){
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

        //we check if it even moved at all.
        if (columnDifference == 0 && rowDifference == 0) {
            return false;
        }
        // Checks to see if the bishop is moving diagonally
        if (columnDifference == rowDifference) {
            return true;
        } else {
            return false;
        }
    }



}