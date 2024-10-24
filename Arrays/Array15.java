import java.util.*;
public class Array15{
    public static int trappedRainwater(int height[]) {
        //calculate left max boundary-array[helper array]
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(height)
        }
        //calculate right max boundary-array[helper array]
       
        //loop
        //waterLevel = min(leftmax bound, rightmax boundary )
        //trapped water= waterLevel-height[]
    }
}
