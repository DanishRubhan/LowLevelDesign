package LLD;

public class NQueen {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[n][n];
        int c=countQueen(board,0);
        System.out.println("Count "+c);
    }

    private static int countQueen(boolean[][] board, int row) {
        if(row==board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;

        for(int col=0;col<board.length;col++) {
            if(isSafe(board,row,col)) {
                board[row][col]=true;
                count+=countQueen(board,row+1);
                board[row][col]=false;
            }
        }

        return count;

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //for vertical
        for(int i=0;i<row;i++) {
            if(board[i][col]) {
                return false;
            }
        }

        //for left diagonal -> row--,col--
        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++) {
            if(board[row-i][col-i]) {
                return  false;
            }
        }

        //for right diagonal -> row--,col++
        int maxright=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxright;i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }
        return  true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row:board) {
            for(boolean e:row) {
                if(e) {
                    System.out.print("Q ");
                }else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }

    }
}
