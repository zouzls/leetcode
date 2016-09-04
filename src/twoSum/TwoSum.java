package twoSum;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    	int[] res=new int[2];
    	HashMap<Integer, Integer> log=new HashMap<>();
    	for(int i=0;i<nums.length;i++){
    		int diff=target-nums[i];
    		if(log.get(diff)!=null){
    			res[0]=log.get(diff);
    			res[1]=i;
    		}else log.put(nums[i], i);
    	}
    	return res;
    }
}
