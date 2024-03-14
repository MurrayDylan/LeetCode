import java.sql.Array;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 3));
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        //Not vert efficient, was in a rush
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(curr == goal) count++;
            for(int j = i+1; j < nums.length; j++) {
                curr += nums[j];
                if(curr == goal) {
                    count++;
                }
            }
        }
        return count;
    }
}