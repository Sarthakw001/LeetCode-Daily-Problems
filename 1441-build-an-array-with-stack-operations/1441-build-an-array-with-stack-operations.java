class Solution {
    static{
        for(int i=1;i<=500;i++)
            buildArray(new int[0],0);
    }
    public static List<String> buildArray(int[] target, int n) {
        int k = 0;
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            while(k<target.length && i!=target[k]){
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
            if(k<target.length){
                ans.add("Push");
            }
            k++;
        }
        return ans;
    }
}