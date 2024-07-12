// 2789. Largest Element in an Array after Merge Operations
// You are given a 0-indexed array nums consisting of positive integers.
// You can do the following operation on the array any number of times:
// Choose an integer i such that 0 <= i < nums.length - 1 and nums[i] <= nums[i + 1]. Replace the element nums[i + 1] with nums[i] + nums[i + 1] and delete the element nums[i] from the array.
// Return the value of the largest element that you can possibly obtain in the final array.


class Solution {
    public long maxArrayValue(int[] nums) {
       int n = nums.length;
      long[] ans=new long[n];
      for(int i=0;i<n;i++){
          ans[i]=nums[i];
      }
        if(n==1) return ans[0];
        if(n==2){
            if(ans[0]<=ans[1]) return ans[0]+ans[1];
            else return ans[0];
        }
        long max = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (ans[i + 1] < ans[i])
                continue;
            else {
                ans[i] = ans[i] + ans[i + 1];
                max = Math.max(max, ans[i]);
            }
        }
        return Math.max(max,ans[0]); 
    }
}
