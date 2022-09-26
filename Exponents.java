import java.util.*;
public class Exponents{

    /* a - n bit integer positive, x = integer */
    public static long getExponents(int a, int x){
        if(a == 1){
            return x;
        }
        long left = getExponents(a / 2, x);
        long right = getExponents(a / 2, x);
        return left * right; 
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is 'a': ");
        int a = scanner.nextInt();
        System.out.println("What is 'x': ");
        int x = scanner.nextInt();
        long result = getExponents(a, x);

        System.out.println("Result: " + result);
        scanner.close();
        
    }
}