import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombinationSUm {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); 
        
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        
        return ans;
    }

    public void findCombinations(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue; 
            }

            if (candidates[i] <= target) {
                current.add(candidates[i]);
                findCombinations(i + 1, candidates, target - candidates[i], ans, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
