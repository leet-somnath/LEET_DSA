import java.util.*;

public class ContainerWIthmostWater{
    static int maxArea(int nums[]) {
        
        int i = 0,j = nums.length - 1, mx = Integer.MIN_VALUE;
    	while(i < j)
    	{
    		int water = (j-i)* Math.min(nums[i],nums[j]);
    		mx = Math.max(mx,water);
    		if(nums[i] < nums[j])
    		    i++;
    		else
    		    j--;
    	}
	
	    return mx;
	}
    public static void main(String args[])
    {
    	int nums[] = {1, 4, 2, 3};
    	
    	System.out.println("Maximum amount of water is: " + maxArea(nums));
    }
}