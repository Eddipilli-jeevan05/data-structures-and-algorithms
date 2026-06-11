import java.util.ArrayList;
import java.util.List;
class Solution {
    public void fun(int arr[],int ind,int target,List<Integer> list,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind == arr.length) return;

        if(arr[ind] <= target){
           list.add(arr[ind]);
           fun(arr,ind,target-arr[ind],list,ans);
           list.remove(list.size()-1);
        }
        
        fun(arr,ind+1,target,list,ans);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        fun(candidates,0,target,list,ans);
        return ans;
    }
}