package Arrays.Hard;

//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: [3]
//Example 2:
//
//Input: nums = [1]
//Output: [1]
//Example 3:
//
//Input: nums = [1,2]
//Output: [1,2]
//
//
//Constraints:
//
//1 <= nums.length <= 5 * 104
//-109 <= nums[i] <= 109

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        if(nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }
        for (int num : nums) {
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }

            if (hm.get(num) > nums.length / 3 && !ans.contains(num)) {
                ans.add(num);
            }
        }

        return ans;
    }
}
