package hw_73;

import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args){
        //System.out.println(fib_recurrence(10));
        System.out.println(fib_recurrence(46));

    }
    //complexity O(2^n)
    public static int fib_recurrence(int num){
        if(num <= 0) return 0;
        if(num == 1) return 1;
        if(num == 2) return 1;
        return fib_recurrence(num - 1) + fib_recurrence(num - 2);
    }
    //complexity O(n)
    public static int fib_grade8(int num){
        if(num <= 0) return 0;
        if(num == 1) return 1;
        if(num == 2) return 1;
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        while(nums.size() < num - 1){
            nums.add(nums.get(nums.size() - 1) + nums.get(nums.size() - 2));
        }
        return nums.get(nums.size() - 1);
    }
    //complexity O(1)
    public static int fib_Binet(int num){
        if(num <= 0) return 0;
        double PHI = 1.6180339887;
        return (int) Math.round((Math.pow(PHI, num) - Math.pow(-1 * PHI, -1 * num)) / (2 * PHI - 1));
    }

}
