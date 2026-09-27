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

        while (left < s.length()) {
            Set<Character> st = new HashSet<>();
            int right = left;

            while (right < s.length()) {
                if (st.contains(s.charAt(right))) {
                    break;
                }

                st.add(s.charAt(right));
                right++;
            }

            int subString = right - left;
            maxSubstring = Math.max(maxSubstring, subString);

            left++;
        }

        return maxSubstring;
    }
}