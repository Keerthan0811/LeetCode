//2864. Maximum Odd Binary Number
// You are given a binary string s that contains at least one '1'.
// You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.
// Return a string representing the maximum odd binary number that can be created from the given combination.
// Note that the resulting string can have leading zeros.

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for(char ch : s.toCharArray())
            if(ch == '1') count++;

        int n = s.length();
        char[] arr = new char[n];

        for(int i=0; i<n; i++)
            arr[i] = '0';

        arr[n-1] = '1';
        count--;

        int i=0;
        while(count-- > 0)
            arr[i++] = '1';

        return new String(arr);
    }
}
