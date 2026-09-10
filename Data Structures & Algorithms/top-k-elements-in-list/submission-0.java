class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] bucket = new List[nums.length + 1]; 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            int key = entry.getKey();

            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
                
            }
            bucket[val].add(key);
        }
        int[] ans = new int[k];
        int idx = 0;
        for(int i = n; i >= 0 && idx < k; i--){
            if(bucket[i] != null){
                for(int j = 0; j < bucket[i].size() && idx<k; j++){
                    ans[idx] = bucket[i].get(j);
                    idx++;
                }
                
            }
        
        }
        return ans;
    }
}
