package LEVEL1;

public class traapWater {

    public static int trap(int[] height) {
        //left
        int n=height.length;
        int leftmax[]=new int[n];
        leftmax[0]=height[0];
        for(int i=0;i<n;i++){
            leftmax[i]=Math.max(leftmax[i+1],height[i]);
        }
        //right
        int rightmax[]=new int[n];
        int rightindex=n-1;
        rightmax[rightindex]=height[rightindex];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],height[i])
        }
        //loop
        int waterlevel=0;
        int trappedwater=0;
        for(int i=0;i<n;i++){
            waterlevel=Math.min(leftmax[i],rightmax[i]);
            trappedwater=waterlevel-height[i];
        }
        return trappedwater;
        
    }

    public static void main(String[] args) {

        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));

    }
    
}
