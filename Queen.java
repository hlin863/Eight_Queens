
public class Queen {
    void QueensAlgorithm(int size){
        // create a stack to track the board items.

        char[][] board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        }; // initalises an empty board.

        if (this.solveQueens(board, 0)){
            System.out.println("Solution found!");
            this.printBoard(board);
        } else {
            System.out.println("No solution found!");
        }

        

    }

    public boolean solveQueens(char[][] board, int column){
        // if we have reached the end of the board, we have found a solution.
        if (column > board.length - 1){
            return true;
        }

        for (int i = 0; i < board.length; i++){
            if (this.guarded(board, i, column)){ // checks whether it is safe to place a queen at this row and column.
                board[i][column] = 'Q'; // if it is safe, place a queen.
                if (this.solveQueens(board, column + 1)){ // if we have found a solution, return true.
                    return true;
                }
                board[i][column] = '.'; // if we have not found a solution, remove the queen.
            }
        }

        return false;
    }

    public void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    boolean guarded(char[][] board, int row, int column){
        
        for (int i = 0; i < column; i++){
            // loop through the board
            if (board[row][i] == 'Q'){
                // if the board is a queen
                return false;
            }
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--){
            // loop through the board
            if (board[i][j] == 'Q'){
                // if the board is a queen
                return false;
            }
        }

        for (int i = row, j = column; i >= 0 && j < board.length; i--, j++){
            // loop through the board
            if (board[i][j] == 'Q'){
                // if the board is a queen
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.QueensAlgorithm(8);
    }
}
