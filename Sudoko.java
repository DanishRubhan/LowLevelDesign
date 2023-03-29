package LLD;

public class Sudoko {
    public static void main(String[] args) {
        int[][] board=
                {
                        {3, 0, 0, 8, 0, 1, 0, 0, 2},
                        {2, 0, 1, 0, 3, 0, 6, 0, 4},
                        {0, 0, 0, 2, 0, 4, 0, 0, 0},
                        {8, 0, 9, 0, 0, 0, 1, 0, 6},
                        {0, 6, 0, 0, 0, 0, 0, 5, 0},
                        {7, 0, 2, 0, 0, 0, 4, 0, 9},
                        {0, 0, 0, 5, 0, 9, 0, 0, 0},
                        {9, 0, 4, 0, 8, 0, 7, 0, 5},
                        {6, 0, 0, 1, 0, 7, 0, 0, 3}
        };
        if(solve(board)) {
            display(board);
        }else {
            System.out.println("Cannot solve this !!");
        }
    }

    static boolean solve(int[][] board) {
         int n=board.length;
         int row=-1;
         int col=-1;

         boolean maxLeft=true;
         for(int i=0;i<n;i++) {
             for(int j=0;j<n;j++) {
                 if(board[i][j]==0) {
                     row=i;
                     col=j;
                     maxLeft=false;
                     break;
                 }
             }
             if(maxLeft==false) {
                 break;
             }
         }
         if(maxLeft==true) {
             return  true;
         }
         for(int number=1;number<=9;number++) {
             if(isSafe(board,row,col,number)) {
                 board[row][col]=number;
                 if(solve(board)) {
                     return true;
                 }else {
                     board[row][col]=0;
                 }
             }
         }
         return false;

    }



    static void display(int[][] board) {
           for(int[] row:board) {
               for(int n:row) {
                   System.out.print(n+" ");
               }
               System.out.println();
           }
    }




    static boolean isSafe(int[][] board,int row,int col,int num) {
            //check row
            for(int i=0;i<board.length;i++) {
                if(board[i][col]==num) {
                    return false;
                }
            }

            //check col
            for(int i=0;i<board.length;i++) {
                if(board[row][i]==num) {
                return false;
            }
        }


        //within the box
        int sqrt=(int) Math.sqrt(board.length);
        int start=row-row%sqrt;
        int end=col-col%sqrt;
        for(int i=start;i<start+sqrt;i++) {
            for(int j=end;j<end+sqrt;j++) {
                if(board[i][j]==num) {
                    return false;
                }
            }
        }
        return true;
    }
}
