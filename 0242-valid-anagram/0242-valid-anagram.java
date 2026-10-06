class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();

        for(char c:t.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        for(char c:s.toCharArray()){
            if(mp.containsKey(c)){
                mp.put(c,mp.get(c)-1);
            }else{
                return false;
            }
        }

        for(Map.Entry<Character,Integer> entry:mp.entrySet()){
            if(entry.getValue() < 0) return false;
            if(entry.getValue() > 0) return false;
        }
        return true;
    }
}