package DSA;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {5,7,8,1,4,3,0};
        int target = 10;
        int[] result = twoSum(arr, target);
        for(int i : result) {
            System.out.println(i);
        }
        int[] resultOpt = twoSumOpt(arr, target);
        for(int i : resultOpt) {
            System.out.println(i);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int nums2 = target - nums[i];
            for(int j = i+1; j<nums.length; j++) {
                if(nums[j] == nums2) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
    public static int[] twoSumOpt(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i= 0; i<nums.length ; i++) {
            indexMap.put(nums[i], i);
        }
        for(int i= 0; i<nums.length; i++) {
            int nums2 = target - nums[i];
            if(indexMap.containsKey(nums2) && indexMap.get(nums2) != i) {
                result[0] = i;
                result[1] = indexMap.get(nums2);
                break;
            }
        }
        return result;
    }
}
