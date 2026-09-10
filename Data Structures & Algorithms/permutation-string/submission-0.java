class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int l = 0, r = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while(r < n2){    
            char chr = s2.charAt(r);
            window.put(chr, window.getOrDefault(chr, 0) + 1);
            
            if(r - l + 1 > n1){
                char leftChar = s2.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(window.get(leftChar) == 0) window.remove(leftChar);
                l++;
            }
            if(map.equals(window)) return true;
            r++;
            
        }
        return false;
    }
}
