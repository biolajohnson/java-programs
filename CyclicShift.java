import java.util.*;

public class CyclicShift {

    public static String shift(String str){
        char[] chars = str.toCharArray();
        char last = str.charAt(str.length() - 1);
        for(int i = chars.length - 1; i > 0; i--){
            chars[i] = chars[i - 1];
        }
        chars[0] = last;
        return new String(chars);
    }

    public static int checkIdenticalPairs(List<Integer> list){
        return 0;
    }

    public static void main(String[] args){
      
    }
}