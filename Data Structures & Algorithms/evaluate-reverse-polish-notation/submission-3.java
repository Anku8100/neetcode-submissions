class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while(i < tokens.length){
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {
                
                int first = s.pop();
                int second = s.pop();
                if(token.equals("+")) s.push(first + second);
            
                else if(token.equals("-")) s.push(second - first);
                
                else if(token.equals("*")) s.push(first * second);
            
                else s.push( second / first);
               
            } 
            else {
                s.push(Integer.parseInt(token));
            }
            
            i++;
        }
        return s.peek(); 
    }
}
