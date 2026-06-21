// Problem: Subset sums 2

// Pattern: Recursion, Backtracking with Loop-Based Choice Pattern

// Approach:
// Sort the array.
// Skip the duplicate branches before generation.
// and explore the next size to generate the subset

// TC: O(2^n * k)
// where n is the number of elements and
// k is the average length of a valid combination

// SC: O(k) recursion stack +
// O(k * x) for storing x valid combinations

//Brute force: Generate all combinations with pick/not pick pattern and store in hashset for unique combinations.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset2 {
    public void subRec(int ind,int arr[],List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=ind;i<arr.length;i++){
            if(i != ind && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            subRec(i+1,arr,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subRec(0,nums,list,ans);
        return ans;
    }
}

