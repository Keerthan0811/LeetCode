// 152. Maximum Product Subarray
// Given an integer array nums, find a subarray
// that has the largest product, and return the product.
// The test cases are generated so that the answer will fit in a 32-bit integer.



  
class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        double prefix=1,suffix=1;
        double ans=nums[0];
        
        for(int i=0;i<n;i++){
            
            prefix = prefix==0 ? 1 : prefix;
            suffix = suffix==0 ? 1 : suffix;
            
            prefix *= (double) nums[i];
            suffix *= (double) nums[n-1-i];
            ans = Math.max(ans,Math.max(prefix,suffix));
            
        }
        
        return (int) ans;

    }
}
