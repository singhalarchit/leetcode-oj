/*

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int[] hash;
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s:strs){
            hash = new int[26];
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(map.containsKey(key))
                map.get(key).add(s);
            else{
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}