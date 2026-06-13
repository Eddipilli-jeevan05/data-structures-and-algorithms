// Problem: Combination Sum II

// Pattern: Recursion, Backtracking with Loop-Based Choice Pattern

// Approach:
// Sort the array.
// Skip duplicate branches before generation.
// Generate only unique combinations.

// TC: O(2^n * k)
// where n is the number of elements and
// k is the average length of a valid combination

// SC: O(k) recursion stack +
// O(k * x) for storing x valid combinations

//Brute force: Generate all combinations with pick/not pick pattern and store in hashset for unique combinations.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class combinationSum2 {
    public void fun(int ind,int target,List<Integer> list,int arr[],List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i > ind && arr[i] == arr[i-1]) continue;
            if(target < arr[i]) break;
            list.add(arr[i]);
            fun(i+1,target-arr[i],list,arr,ans);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> combinationsum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fun(0,target,list,candidates,ans);
        return ans;

    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2};
        int target = 4;
        System.out.println(new combinationSum2().combinationsum2(arr,target));
    }
}
