class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int i = 0; i< nums.length; i++){
            int curr = nums[i];
            if(set.contains(curr - 1)) continue;
            int count = 0;
            while(set.contains(curr)){
                count++;
                curr += 1;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }
}
