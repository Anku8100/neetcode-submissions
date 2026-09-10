class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 < n2) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, required = map.size();
        int minLen = Integer.MAX_VALUE;
        String ans = new String();
        while(r < n1){
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if(map.containsKey(ch) &&
                window.get(ch).equals(map.get(ch))) have++;

            if(have == required){
                while(have == required){
                    char left = s.charAt(l);
                    
                    window.put(left, window.get(left) -1);
                    if(map.containsKey(left) &&
                        window.get(left) < map.get(left)) have--;

                    if(window.get(left) == 0) window.remove(left);
                    if(minLen > r - l + 1){
                        ans = s.substring(l, r+1);
                        minLen = r - l + 1;
                    }
                    l++;
                }
                
            }
            r++;
        }
        return ans;
    }
}
