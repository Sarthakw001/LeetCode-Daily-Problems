class Solution {
    public boolean isPalindrome(String s) {
        s=s.toUpperCase();
        char[] ch = cleanString(s).toCharArray();
        int left = 0, right = ch.length - 1;
        while(left < right){
            if(ch[left] != ch[right])
                return false;
            left++;
            right--;
        }   
        return true;
    }

    public String cleanString(String s){
        StringBuilder cleanedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                cleanedString.append(c);
            }
        }
        return cleanedString.toString();
    }
}