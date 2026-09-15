// •	Shall define one class for each of the chess pieces with the following data: piece_name, color, column, row.
// Methods: empty constructor, constructor with parameters for each class field, getter methods for color, column, and row fields, setter for column and row, method to verify its piece movement verifyTarget(column, row)

public class Queen{
    // Attributes (Info hiding / Encapsulation)
    private String piece_name;
    private String color;
    private char column;
    private int row;

    // Methods
    // Empty constructor
    public Queen(){
        this.piece_name = PieceType.QUEEN.name();
        this.color = "White";
        this.column = 'A';
        this.row = 1;
    }

    // Constuctor with parameters
    public Queen(String piece_nameIn, String colorIn, char ColumnIn, int rowIn){
        this.piece_name = piece_nameIn;
        this.color = colorIn;
        this.column = ColumnIn;
        this.row = rowIn;   
    }

    // Getters 
    public String getPieceName() {
        return this.piece_name;
    }

    public String getColor(){
        return this.color;
    }

    public char getColumn(){
        return this.column;
    }

    public int getRow(){
        return this.row;
    }

    // Setters for column and row
    public void setColumn(char columnIn){
        this.column = columnIn;
    }

    public void setRow(int rowIn){
        this.row = rowIn;
    }

    // Method to verify piece movement
    // Can move vertically or horizontally, or diagonally.
    public boolean verifyTarget(char targetColumn, int targetRow){
        // Check if it stays in the same position
        if(targetColumn == this.column && targetRow == this.row){
            return false;
        }
        // Get absolute differences between positions
        int differenceColumn = Math.abs(targetColumn - this.column);
        int differenceRow = Math.abs(targetRow - this.row);

        // Check for vertical, horizontal, or diagonal movement
        return (targetColumn == this.column || targetRow == this.row || differenceColumn == differenceRow);
    }
}