package algorithm.practice;

public class 문자열_뒤집기 {

    public static void main(String[] args) {
        String str = "hello world!";
        String reverseStr = reverse(str);
        System.out.println("reverseStr = " + reverseStr);
    }

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

}

