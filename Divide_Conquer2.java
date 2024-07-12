// 4. Median of Two Sorted Arrays
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).



  
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;

        if(x>y){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = x;

        while(low<=high){
            int partitionX = (low + high) /2;
            int partitionY = (x + y + 1)/2 - partitionX;
            //left side is max and right is min
            int left1 = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int right1 = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int left2 = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int right2 = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if(left1 <= right2 && left2 <= right1){
                if((x + y) % 2 == 0) {
                    // return (double) ((Math.max(left1, left2) + Math.min(right1, right2))/2);
                    return (double) (Math.max(left1, left2) + Math.min(right1, right2))/2;
                }
                else{
                    return (double) Math.max(left1, left2);
                }
            }
            else if(left1 > right2) {
                high = partitionX-1;
            }
            else{
                low = partitionX+1;
            }
        }

        return -1;

    }
}
