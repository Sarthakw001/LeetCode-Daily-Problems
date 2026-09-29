class Solution {
    int rows;
    int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        int orignalColor = image[sr][sc];

        if(color == orignalColor) return image;

        dfs(image,sr,sc,orignalColor,color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int orignalColor,int color){
        if(r<0 || r>=rows || c<0 || c>=cols)
            return;
        
        if(image[r][c] != orignalColor)
            return;

        image[r][c] = color;

        dfs(image,r+1,c,orignalColor,color);
        dfs(image,r-1,c,orignalColor,color);
        dfs(image,r,c+1,orignalColor,color);
        dfs(image,r,c-1,orignalColor,color);
    }
}