// 1. flood fill

class Solution {
    public void solve(int[][] image, int sr, int sc, int color, int orcolor){
        if(sr < 0 || sc<0 || sr >= image.length || sc >= image[0].length) return;
        else if(image[sr][sc] != orcolor) return;
        else if (image[sr][sc] == color) return;
        image[sr][sc] = color;
        solve(image , sr+1, sc ,color, orcolor);// down
        solve(image , sr-1, sc ,color, orcolor);//up
        solve(image , sr, sc+1 ,color, orcolor);//right
        solve(image , sr, sc-1 ,color, orcolor);//left
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orcolor = image[sr][sc];
         solve(image , sr, sc ,color,orcolor);
         return image;
    }
}