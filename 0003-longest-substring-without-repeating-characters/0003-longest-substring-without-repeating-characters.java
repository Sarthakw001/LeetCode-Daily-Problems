class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.lengthOfLongestSubstring("");
        }
    }
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxSubstring = 0;
        Set<Character> st = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (st.contains(s.charAt(right))) {
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(right));
            maxSubstring = Math.max(maxSubstring, right - left + 1);
        }
        return maxSubstring;
    }
}