package DSA;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,3,4,2};
        System.out.println(findSingleNumber(arr));
    }

    private static int findSingleNumber(int[] arr) {
        int result = 0;
        for(int num : arr) {
            result ^= num;
        }
        return result;
    }
}
