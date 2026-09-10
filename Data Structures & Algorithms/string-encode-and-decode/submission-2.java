class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for(String str : strs){
            encodedStr.append(str.length()).append('#').append(str);
        }
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        
        List<String> decodedStr = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int sepIdx = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, sepIdx));
            i = sepIdx + 1;
            String string = str.substring(i, i + len);
            decodedStr.add(string);
            i = i+ len;
        }
        return decodedStr;
    }
}
