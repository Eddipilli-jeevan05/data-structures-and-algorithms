// Problem: N-Queens

// Pattern: Recursion, Backtracking with Row-wise/Column-wise Placement + Hashing

// Approach:
// Place one queen in each row (or column).
// For every position, check if the column and both diagonals are safe.
// If safe, place the queen, mark the column and diagonals.
// Recurse to the next row.
// After returning, remove the queen and unmark the column and diagonals (backtracking).
// When all rows are processed, store the current board configuration.

// TC: O(N!)
// (At each row, we try available columns. The search space is bounded by N!)

// SC: O(N)
// O(N) recursion stack +
// O(N) for column hash +
// O(2N-1) for left diagonal hash +
// O(2N-1) for right diagonal hash
// (Excluding the space used to store the final answers.)

// Brute Force:
// For every queen placement, iterate through the board to check
// the column, left diagonal, and right diagonal.
// This makes every safety check O(N), leading to a much slower solution.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class nQueens {
    public void recFun(int row,List<StringBuilder> board,List<List<String>> ans,int n,HashMap<Integer,Integer> hm,HashMap<Integer,Integer> leftUpper,HashMap<Integer,Integer> rightUpper){
        if(row == n){
           List<String> temp = new ArrayList<>();
           for(StringBuilder roww: board){
             temp.add(roww.toString());
           } 
           ans.add(temp);
           return;
        }

        for(int i=0;i<n;i++){
            if((hm.get(i) == 0) && (leftUpper.get(n-1+(i-row)) == 0) && (rightUpper.get(row+i) == 0)){
                board.get(row).setCharAt(i,'Q');
                hm.put(i,1);
                leftUpper.put(n-1+(i-row),1);
                rightUpper.put(row+i,1);
                recFun(row+1,board,ans,n,hm,leftUpper,rightUpper);
                board.get(row).setCharAt(i,'.');
                hm.put(i,0);
                leftUpper.put(n-1+(i-row),0);
                rightUpper.put(row+i,0);
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder row = new StringBuilder();
            for(int j=0;j<n;j++){
                row.append('.');
            }
            board.add(row);
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(i,0);
        }
        HashMap<Integer,Integer> leftUpper = new HashMap<>();
        HashMap<Integer,Integer> rightUpper = new HashMap<>();
        for(int i=0;i<=(2*n)-1;i++){
            leftUpper.put(i,0);
            rightUpper.put(i,0);
        }
        recFun(0,board,ans,n,hm,leftUpper,rightUpper);
        return ans;
    }
}