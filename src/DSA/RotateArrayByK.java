package DSA;

class RotateArrayByK {

    public static void main(String[] args) {
        int[] arr2 = {-1,-100, 3, -99};
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr = {1,2};
//        rotate(arr, 0);
        int i =0;
        while(i < arr1.length) {
            System.out.print(arr1[i++]);
        }
        System.out.println();
        rotateWithReversal(arr1, 3);
        i = 0;
        while(i < arr1.length) {
            System.out.print(arr1[i++]);
        }
    }

    public static int[] rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] temp = new int[length];
        int i = 0;

        while (i < k) {
            temp[i] = nums[(length - k) + i];
            i++;
        }
        int j = 0;
        while (k != 0 && j <= k && k+j < length) {
            temp[k + j] = nums[j];
            j++;
        }
        i = 0;
        while (k != 0 && i < length) {
            nums[i] = temp[i];
            i++;
        }
        return nums;
    }

    public static int[] rotateWithReversal(int[] nums, int k) {
        int length = nums.length;
        k = k%length;
        int temp;
        int i =0;
        int j = 0;
        //reverse k elements
        for(i = length - k, j = length-1 ; i < j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        //reverse n-k elements
        for(i = 0, j = length - (k+1); i<j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        //reverse entire array
        for(i = 0, j = length-1; i<j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}