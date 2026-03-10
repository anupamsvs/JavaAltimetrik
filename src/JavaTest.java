import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class JavaTest {
    public static void main(String[] args) {
        String str = "Venezuela is under US invasion";
        System.out.println(reverseLettersInWords(str));
        System.out.println(reverseWords(str));
    }

    private static String reverseWords(String str) {
        var words = Arrays.asList(str.split(" "));
        Collections.reverse(words);
        return words.stream().collect(Collectors.joining(" "));
    }

    private static String reverseLettersInWords(String str) {
        return Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int length = nums.length;

            int[] temp = new int[length];
            int i = 0;

            while(i < k)  {
                temp[i] = nums[(length - k) + i];
                i++;
            }
            int j = 0;
            while(j <= k) {
                temp[j] = nums[j];
                j++;
            }
            i = 0;
            while(i < length) {
                nums[i] = temp[i];
                i++;
            }
        }
    }
}
