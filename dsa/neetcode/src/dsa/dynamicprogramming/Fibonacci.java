package dsa.dynamicprogramming;
import java.util.Map;
import java.util.HashMap;
/**
 * @author vkiprono
 * @created 3/18/24
 */

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(10));
    }
    //Using Arrays
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    //Using HashMap
    public int fib1(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        if (n <= 1) {
            return n;
        }
        map.put(0, 0);
        map.put(1, 1);

        for (int i = 2; i <= n; i++) {
            map.put(i,(map.get(i - 1)) + map.get(i - 2));
        }
        return map.get(n);
    }
}
