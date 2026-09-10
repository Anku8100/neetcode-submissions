class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        if(s.length() == 1) return 1;
        int maxLength = 0;
        for(int i = 0; i< s.length(); i++){
            for(int j = i; j< s.length(); j++){
                char ch = s.charAt(j);
                if(set.contains(ch)){
                    maxLength = Math.max(maxLength, set.size());
                    set.clear();
                    break;
                }
                else set.add(ch);
            }
        }
        return maxLength;
    }
}
