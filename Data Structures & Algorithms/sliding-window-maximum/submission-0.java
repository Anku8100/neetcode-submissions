class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] maxArray = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for(int i = 0; i< n; i++){
            if(!dq.isEmpty() && dq.getFirst() <= i - k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1 && idx < n - k + 1){
                maxArray[idx] = nums[dq.getFirst()];
                idx++;
            }

        }
        return maxArray;
    }
}
