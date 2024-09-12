package Amazon;

import java.util.Arrays;

public class TrappingRainWater {

    public static int trap(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        int max_water = 0;
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        for(int i=1; i<height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        int[] maxRight = new int[height.length];
        maxRight[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        for(int i=0; i<height.length; i++) {
            max_water += (Math.min(maxLeft[i], maxRight[i]))-height[i];
        }
        return max_water;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
