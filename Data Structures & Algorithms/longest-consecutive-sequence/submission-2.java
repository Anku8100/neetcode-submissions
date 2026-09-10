class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int num : set){
            
            if(set.contains(num - 1)) continue;
            int count = 0;
            while(set.contains(num)){
                count++;
                num += 1;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }
}
