package Arrays.Easy;

//Given a binary array nums, return the maximum number of consecutive 1's in the array.
//
//
//
//Example 1:
//
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
//Example 2:
//
//Input: nums = [1,0,1,1,0,1]
//Output: 2
//
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1.

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int currAns = 0;
        int n = nums.length;
        if(n == 1){
            if(nums[0] == 1)
                return 1;
            return 0;
        }
        int first = 0;

        for(int i = 0 ; i < n; i++){
            if(nums[i] == 1){
                first = i;
                ans = 1;
                currAns = 1;
                break;
            }
        }
        int second = first + 1;

        while(first <= second && second < n){
            if(nums[first] == 1){
                if(nums[second] == 1){
                    currAns++;
                    second++;
                }
                else if(nums[second] == 0){
                    if(ans < currAns){
                        ans = currAns;
                    }
                    currAns = 0;
                    first = second + 1;
                    second = first;
                }
            }
            else{
                first++;
                second++;
            }

        }

        if(ans < currAns){
            ans = currAns;
        }

        return ans;
    }
}
