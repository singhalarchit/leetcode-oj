/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length())
            return res;
            
        //Map for string p
        int[] map = new int[26];
        for(char c:p.toCharArray())
            map[c-'a']++;
        
        //To keep track of starting position of anagram
        int start = 0;
        
        //Map for string s
        int[] map_s = new int[26];
        
        //Move end till end of s
        int end = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);

            if(map[c-'a'] > 0){
                
                // If c in p, update map_s
                map_s[c-'a']++;
                
                if(end-start+1 == p.length()){
                    if(Arrays.equals(map,map_s))
                        res.add(start);
                    //Update map_s and start
                    map_s[s.charAt(start)-'a']--;
                    start++;
                }
                end++;
            }
            else{
                // If c not in p, set start to end+1; reset count and map_s
                start = ++end;
                Arrays.fill(map_s,0);
            }
            
        }
        
        return res;
    }
}