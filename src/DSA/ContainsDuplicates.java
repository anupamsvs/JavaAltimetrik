package DSA;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,6};
        System.out.println(containsDuplicateUsingSet(nums));
        System.out.println(containsDuplicates(nums));
        System.out.println(containsDuplicatesWhileAddingToSet(nums));
    }
    public static boolean containsDuplicateUsingSet(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        Set s = new HashSet(list);
        return !(nums.length == s.size());
    }

    public static boolean containsDuplicates(int[] nums) {
        long count = Arrays.stream(nums).boxed().distinct().count();
        return !(count == nums.length);
    }

    public static boolean containsDuplicatesWhileAddingToSet(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i< nums.length; i++) {
            if(!s.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
