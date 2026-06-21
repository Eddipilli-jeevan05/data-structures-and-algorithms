// Problem: Subset sums 1
// Genrate all the sums of subsets of the given array


// Pattern: pick/not pick



// Approach:
// Generate all possible combinations of the array elements using recursion.
// Keep those sums in an arraylist and return it.

// TC: O(2^n)
// where n is the number of elements

// SC: O(2^n) recursion stack +
// O(k * x) for storing x valid combinations


import java.util.ArrayList;

public class subset {
    public void recSub(int ind,int sum,int arr[],ArrayList<Integer> ans){
        if(ind == arr.length){
            ans.add(sum);
            return;
        }
    
        recSub(ind+1,sum+arr[ind],arr,ans);
        recSub(ind+1,sum,arr,ans);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        recSub(0,0,arr,ans);
        return ans;
        
    }

}
