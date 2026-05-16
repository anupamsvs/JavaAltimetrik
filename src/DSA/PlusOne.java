package DSA;

import java.util.Arrays;

public class PlusOne {

    static void main() {
        int[] num = {8,9,9,9};
        System.out.println(Arrays.toString(plusOne((num))));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if(digits[length-1] != 9) {
            digits[length-1] = digits[length-1] + 1;
            return digits;
        }
        int sum = 0;
        for(int i=0; i<length; i++) {
            int num = (int) (digits[length-1-i] * Math.pow(10,i));
            sum = sum + num;
        }
        int num = sum + 1;
        int i =0;
        sum = 0;
        length = length + 1;
        int[] d = new int[length];
        while(num > 0) {
            int n = num%10;
            d[length-i-1] = n;
            num = num/10;
            i++;
        }
        return d;
    }
}

