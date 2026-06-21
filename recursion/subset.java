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
