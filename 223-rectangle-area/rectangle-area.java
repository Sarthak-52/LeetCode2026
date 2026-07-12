class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int ax = ax2 - ax1;
        int ay = ay2 - ay1;
        int a = ax * ay;
        int bx = bx2 - bx1;
        int by = by2 - by1;
        int b = bx * by;
        int cx ,cx1 , cx2;
        if(ax1 >= bx2 || ax2 <= bx1 || ay1 >= by2 || ay2 <= by1){
            return a + b;    
        }
        if(ax1 <= bx1 && ax2 >= bx2){
            cx1 = bx1;
            cx2 = bx2;
        }
        else if(ax1 >= bx1 && ax2 <= bx2){
            cx1 = ax1;
            cx2 = ax2;
        }
        else if(ax1 <= bx1 && ax2 <= bx2){
            cx1 = bx1;
            cx2 = ax2;
        }
        else if(ax1 >= bx1 && ax2 >= bx2){
            cx1 = ax1;
            cx2 = bx2;
        }
        else{
            cx1 = ax1;
            cx2 = ax2;
        }
        cx = cx2 - cx1;
        int cy ,cy1 ,cy2;
        if(ay1 <= by1 && ay2 >= by2){
            cy1 = by1;
            cy2 = by2;
        }
        else if(ay1 >= by1 && ay2 <= by2){
            cy1 = ay1;
            cy2 = ay2;
        }
        else if(ay1 <= by1 && ay2 <= by2){
            cy1 = by1;
            cy2 = ay2;
        }
        else if(ay1 >= by1 && ay2 >= by2){
            cy1 = ay1;
            cy2 = by2;
        }
        else{
            cy1 = ay1;
            cy2 = ay2;
        }
        cy = cy2 - cy1;
        int c = cx * cy;
        return a + b - c;
    }
}