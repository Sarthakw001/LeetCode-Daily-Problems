class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();

        for(char c:t.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        for(char c:s.toCharArray()){
            if(mp.containsKey(c)){
                mp.put(c,mp.get(c)-1);
                if(mp.get(c) == 0)
                    mp.remove(c);
            }
            else
                return false;
        }

        return mp.size() > 0 ? false : true;
    }
}