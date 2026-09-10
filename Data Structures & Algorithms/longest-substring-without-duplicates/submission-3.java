class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        if(s.length() == 1) return 1;
        int maxLength = 0;
        // for(int i = 0; i< s.length(); i++){
        //     for(int j = i; j< s.length(); j++){
        //         char ch = s.charAt(j);
        //         if(set.contains(ch)){
        //             maxLength = Math.max(maxLength, set.size());
        //             set.clear();
        //             break;
        //         }
        //         else set.add(ch);
        //     }
        // }
        int l = 0, r = 0;
        while(r < n){
            char ch = s.charAt(r);
            if(set.contains(ch)){
                while(set.contains(ch)){
                    set.remove(s.charAt(l));
                    l++;
                }
                 
            }
            maxLength = Math.max(maxLength, r-l+1);
            set.add(ch);
            r++;
            
            
        }
        return maxLength;
    }
}
