class MinStack {
    ArrayList<Integer> list;
    ArrayList<Integer> minList;
    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if(minList.size() == 0) minList.add(val);
        else{
            int currMin = minList.get(minList.size() - 1);
            minList.add(Math.min(currMin, val));
        }
    }
    
    public void pop() {
        if(list.isEmpty()) return;
        
        list.remove(list.size() - 1);
        minList.remove(minList.size() - 1);
    }
    
    public int top() {
        if(list.isEmpty()) return -1;
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return minList.get(minList.size() - 1); 
    }
}
