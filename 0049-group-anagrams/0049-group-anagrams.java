class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            if(mp.containsKey(sortedStr)){
                mp.get(sortedStr).add(s);
            }else{
                List<String> anagrams = new ArrayList<>();
                anagrams.add(s);
                mp.put(sortedStr,anagrams);
            }
        }
        return new ArrayList<>(mp.values());
    }
}