import java.util.ArrayList;
import java.util.List;

public class permutation1 {
    public void permuteRec(List<Integer> list,List<List<Integer>> ans,int arr[]){
        if(list.size() == arr.length){
           ans.add(new ArrayList<>(list));
           return;
        }
        for(int i=0;i<arr.length;i++){
            if(!(list.contains(arr[i]))){
                list.add(arr[i]);
                permuteRec(list,ans,arr);
                list.remove(list.size()-1);
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteRec(new ArrayList<>(),ans,nums);
        return ans;
    }
}
