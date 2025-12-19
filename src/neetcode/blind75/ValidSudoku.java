package neetcode.blind75;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','1','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board3 = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };

        ValidSudoku validSudoku = new ValidSudoku();
        validSudoku.isValidSudoku(board);
        validSudoku.isValidSudoku(board2);
        validSudoku.isValidSudoku(board3);
    }
    public boolean isValidSudoku(char[][] board) {
        // Verify if it is a 9*9 two dimensional array
        int row = board.length;
        int column = board[0].length;

        Map<Character,Integer>[] mapArrayRow = (Map<Character, Integer>[]) new HashMap[9];
        for(int i=0; i<mapArrayRow.length; i++){
            mapArrayRow[i] = new HashMap<>();
        }

//        System.out.println("row: "+row+ " column: "+  column);

        //Insert into array of map and check whether the map contains a value that appears more than once in
        // a row of sudoku
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                    continue;
//                System.out.println("Boardij value is:"+board[i][j]);
                mapArrayRow[i].put(board[i][j], mapArrayRow[i].getOrDefault(board[i][j],0)+1);
                if(mapArrayRow[i].get(board[i][j]) > 1 || Character.getNumericValue(board[i][j])>9 || Character.getNumericValue(board[i][j])<0) {
                    System.out.println("Duplicate found in row. Not a valid sudoku");
                    return false;
                }

            }
        }

        // Check if any of the columns have duplicate values
        Map<Character,Integer>[] mapArrayCol = (Map<Character, Integer>[]) new HashMap[9];
        for(int i=0; i<mapArrayRow.length; i++){
            mapArrayCol[i] = new HashMap<>();
        }
        for(int i=0; i<column; i++){
            for(int j=0; j<row; j++){
                if(board[i][j] == '.')
                    continue;
                mapArrayCol[j].put(board[i][j], mapArrayCol[j].getOrDefault(board[i][j], 0)+1);
                if(mapArrayCol[j].get(board[i][j]) > 1 || Character.getNumericValue(board[i][j]) < 0 || Character.getNumericValue(board[i][j]) > 9) {
                    System.out.println("Duplicate found in column. Not a valid sudoku");
                    return false;
                }
            }
        }

        //Check if the 3*3 squares have any duplicate values. There are 9 squares. Create a hashSet with
        // a key that represents the squares and then check if it is possible to add all the elements of
        // a square in the HashSet
        Map<Character, Integer>[] hashMap = (Map<Character, Integer>[]) new HashMap[9];
        for(int i=0; i<hashMap.length; i++){
            hashMap[i]= new HashMap<>();
        }

        for(int i=0; i<column; i++){
            for(int j=0; j<row; j++){
                System.out.println("Boardij value is:"+board[i][j]);
                System.out.println("Computed key is:"+computeKey(i,j));
                System.out.println("Computed index is:"+computeIndex(computeKey(i,j))+ "\n");
                if(board[i][j] == '.')
                    continue;
                // Check if value already exists in the correct hashmap
                if(hashMap[computeIndex(computeKey(i,j))].containsKey(board[i][j])) {
                    System.out.println("Duplicate found in subgrid. Not a valid sudoku");
                    return false;
                }
                // Put the value if it does not exist. The value is actually not needed here
                //Could have used a HashSet
                hashMap[computeIndex(computeKey(i,j))].put(board[i][j], i + j*10);
            }
        }

        return true;
    }

    public String computeKey(int rowNum, int colNum){
        String result;
        result = Integer.toString((int)(rowNum/3)) + "," + Integer.toString((int)(colNum/3));
        return result;
    }

    public int computeIndex(String coordinate){
        int index;
        String[] xy = coordinate.split(",");
        index = (Integer.parseInt(xy[0]) * 3) + Integer.parseInt(xy[1]);
        return index;
    }
}
