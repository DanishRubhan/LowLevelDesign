package LLD;

import java.util.Scanner;


public class TicTacToe {

    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int row=0;row<board.length;row++) {
            for(int col=0;col<board[row].length;col++) {
                board[row][col]= ' ';
            }
        }

        char player='X';
        boolean gameOver=false;
        Scanner scanner=new Scanner(System.in);

        while(!gameOver) {
            displayBoard(board);
            System.out.print("Player "+ player+" Enter row and col : ");
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            if(board[row][col]==' ') {
                board[row][col]=player;
                gameOver=haveWon(board,player);
                if(gameOver) {
                    System.out.print("Player "+ player +" has won");
                } else {
                    //check for draw
                    boolean isDraw=true;
                    for(int i=0;i<board.length;i++) {
                        for(int j=0;j<board[i].length;j++){
                            if(board[i][j]== ' ') {
                                isDraw=false;
                                break;
                            }
                        }
                        if(!isDraw) {
                            break;
                        }
                    }
                    if(isDraw) {
                        System.out.print("The Game Has Ended in a Draw !! ");
                        gameOver=true;
                    }else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                }
            } else {
                System.out.print("Invalid Move . Try Again !! ");
            }
        }
    }
    static boolean haveWon(char[][] board,char player) {
        //check for rows
        for(int row=0;row<board.length;row++) {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
                return true;
            }
        }

        //check for columns
        for(int col=0;col<board[0].length;col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
                return true;
            }
        }

        //check for diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
            return true;
        }

        if(board[0][2]==player && board[1][1]==player && board[2][0]==player) {
            return true;
        }


        return false;
    }

    static void displayBoard(char[][] board) {
        for(int row=0;row<board.length;row++) {
            for(int col=0;col< board[row].length;col++) {
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }

}
