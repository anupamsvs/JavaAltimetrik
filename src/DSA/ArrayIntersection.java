package DSA;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] arr = intersect(nums1, nums2);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] resultArr = nums1.length > nums2.length ? new int[nums2.length] : new int[nums1.length];
        int j =0;
        for(int i = 0; i < nums1.length; i++) {
            if(nums1[i] != nums2[j]) {
                j++;
            } else {
                resultArr[i] = nums1[i];
                i++;
                j++;
            }
        }
        return resultArr;
    }
}
