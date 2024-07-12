// 268. Missing Number
// Given an array nums containing n distinct numbers in the range [0, n], 
// return the only number in the range that is missing from the array.

  
int missingNumber(int* nums, int numsSize) {
    int n[numsSize+1];
    for(int i=0;i<=numsSize;i++){
        n[i]=0;
    }
    for(int i=0;i<numsSize;i++){
        n[nums[i]]=1;
    }
    for(int i=1;i<=numsSize;i++){
            if(n[i]!=1)
                return i;
    }
    return 0;
}
