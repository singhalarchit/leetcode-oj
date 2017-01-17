/*

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        return subsets(nums, 0, len-1);
    }
    
    public List<List<Integer>> subsets(int[] nums, int start, int end) {
        
        List<List<Integer>> res = new LinkedList<>();
        if(start>end)
            return res;
        if(start == end){
            List<Integer> list = new LinkedList<>();
            list.add(nums[start]);
            res.add(list);
            res.add(new LinkedList<Integer>());
            return res;
        }
        for(List<Integer> list: subsets(nums, start+1, end)){
            //Initialize new LinkedList, else it will get overwritten
            List<Integer> list2 = new LinkedList<>(list);
            list2.add(0,nums[start]);
            res.add(list);
            res.add(list2);
        }
        return res;
    }
}