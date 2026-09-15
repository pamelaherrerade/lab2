/*
Author(s): Andres Iglesias, Diana Islava Rauda, Pamela Herrera
Primary controller for chess movement verifier
Changelog:
12/09 - Created main class, temp enum for pieces (testing), switch to get specified piece
13/09 - Created methods to verify piece name,color, and positions
14/09 - Finalized logic for the main loops and inputs
 */
import java.util.Scanner;
public class Main{
    //global variables, easy to change and use
    static Chessboard chessboard = new Chessboard();
    static String pieceName;
    static String color;
    static char column;
    static int row;
    static char targetCol;
    static int targetRow;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("This programs seeks to help a user check if a given chess move is valid.");
        System.out.println("To utilize this program, type the specified information of the piece");
        System.out.println("Then, push enter to move to the next requirement");

        boolean start=true;
        PieceType pieceType_name;

        //1st loop is for the initial/new chesspiece
        while (start){
            try{
                System.out.println("Please enter the following information in this format: piece,color,x_position,y_position");
                System.out.println("e.g.: pawn,black,d,4");
                String piece_info=input.nextLine();
                String [] piece_infoParts=piece_info.split(",");

                pieceName=piece_infoParts[0].trim().toUpperCase(); //get piece name and convert it to upper case for ease
                color=piece_infoParts[1].trim().toUpperCase(); //get color of the piece
                verifyInput(input);
                pieceType_name=PieceType.valueOf(pieceName); //get corresponding enum type

                column=piece_infoParts[2].trim().toUpperCase().charAt(0); //get column and row, then check validity
                row=Integer.parseInt(piece_infoParts[3].trim());
                verifyPosition(input);
            } catch(Exception e){
                System.out.println("Invalid input, please try again!");
                continue;
            }
            
            
            boolean checkingTargetPos=true; 
            while (checkingTargetPos){
                try{
                    System.out.println("Please enter the target position for the "+pieceName+" piece");
                    String targetPosition=input.nextLine();
                    String indivPositions[]=targetPosition.split(",");
                    targetCol=indivPositions[0].trim().toUpperCase().charAt(0); //get column and row, then check validity
                    targetRow=Integer.parseInt(indivPositions[1].trim());
                    verifyPosition(input,'a',1);
                } catch(Exception e){
                    System.out.println("Invalid input, please try again!");
                    continue;
                }   
                

            boolean isValidMove=false;
            switch (pieceType_name) {
                case PAWN:
                    Pawn pawn = new Pawn(pieceName,color,column,row);
                    isValidMove = pawn.verifyTarget(targetCol, targetRow);
                break;
                case ROOK:
                    Rook rook = new Rook(pieceName,color,column,row);
                    isValidMove = rook.verifyTarget(targetCol, targetRow);
                break;
                case BISHOP:
                    Bishop bishop = new Bishop(pieceName,color,column,row);
                    isValidMove = bishop.verifyTarget(targetCol, targetRow);
                break;
                case KNIGHT:
                    Knight knight = new Knight(pieceName,color,column,row);
                    isValidMove = knight.verifyTarget(targetCol, targetRow);        
                break;
                case QUEEN:
                    Queen queen = new Queen(pieceName,color,column,row);
                    isValidMove = queen.verifyTarget(targetCol, targetRow);
                break;
                case KING: 
                    King king = new King(pieceName,color,column,row);
                    isValidMove = king.verifyTarget(targetCol, targetRow);
                break;
            }

                if (isValidMove){
                    System.out.println("The "+pieceName+" at"+column+","+row+" can move to "+targetCol+", "+targetRow);
                } else{
                    System.out.println("The "+pieceName+" at"+column+","+row+" can not move to "+ targetCol+", "+targetRow);
                }

                System.out.println("Would you like to check for a different coordinate (same piece)? (Y/N)");
                String answer=input.nextLine();
                if(answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("no")){
                    break;
                }
            }
            System.out.println("Would you like to check for another piece? (Y/N)");
            String answer=input.nextLine();
            if(answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("no")){
                System.out.println("Thank you for playing!");
                break;
            }   
        }
        input.close();
    }

    //verifies if current position is possible, ask again if not
    public static void verifyPosition(Scanner input){
        //initial/basic check if the positions given are within the board
        boolean withinBoard= chessboard.withinChessboard(column,row);
        if (withinBoard){
            return;
        }
        //if the coordinates are outside/invalid, loop until valid
        while(!withinBoard){
            System.out.println("Please enter a coordinate within the chessboard (a-h,1-8)");
            String target_coord=input.nextLine();
            String [] target_coords=target_coord.split(",");
                column=target_coords[0].trim().toUpperCase().charAt(0);
                row=Integer.parseInt(target_coords[1].trim());
            withinBoard= chessboard.withinChessboard(column,row);
        }
        return;
    }

    //verifies if target position is possible, ask again if not
    public static void verifyPosition(Scanner input,char temp,int temp2){
        //initial/basic check if the positions given are within the board
        boolean withinBoard= chessboard.withinChessboard(targetCol,targetRow);
        if (withinBoard){
            return;
        }
        //if the coordinates are outside/invalid, loop until valid
        while(!withinBoard){
            System.out.println("Please enter a coordinate within the chessboard (a-h,1-8)");
            String target_coord=input.nextLine();
            String [] target_coords=target_coord.split(",");
            targetCol=target_coords[0].trim().toUpperCase().charAt(0);
            targetRow=Integer.parseInt(target_coords[1].trim());
            withinBoard= chessboard.withinChessboard(targetCol, targetRow);
        }
        return;
    }
    
    //check if the name and color of the piece are possible, ask again if not
    public static void verifyInput(Scanner input){
        //check if color and piece name is valid
        boolean verifyColor=color.equalsIgnoreCase("black") || color.equalsIgnoreCase("white");
        boolean verifyName=verifyName();
        //if one or the other aren't valid/are false, loop until both are correct
        while (!(verifyColor && verifyName)){
            if(!verifyName){
                System.out.print("Please enter a valid chesspiece name:");
                pieceName=input.nextLine().toUpperCase().trim();
                verifyName=verifyName();
            } 
            if (!verifyColor){
                System.out.print("Please enter a valid chesspiece color:");
                String color=input.nextLine().toUpperCase().trim();
                verifyColor=color.equalsIgnoreCase("black") || color.equalsIgnoreCase("white");
            }
        }
        return;
    }

    //loop through the values of the enum PieceType, if the value of the given name exists within the enum, return true
    public static boolean verifyName(){
        boolean validPiece;
        for (PieceType piece:PieceType.values()){
            validPiece=PieceType.valueOf(pieceName)==piece;
            if (validPiece){
                return true;
            }
        }
        return false;
    }
    
}
