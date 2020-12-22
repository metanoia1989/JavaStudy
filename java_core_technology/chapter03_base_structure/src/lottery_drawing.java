import java.math.BigInteger;
import java.util.Scanner;
import java.util.Arrays;

public class lottery_drawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        System.out.print("How many nubmers do you need do draw？");
        int k = in.nextInt();

        System.out.print("What is the hightest nubmer you can draw？");
        int n = in.nextInt();
         
        // fill an array with numbers 1 2 3 . . . n
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; 
        }
        // draw k numbers and put them into a second array
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            // 设置随机数索引 0~n-1 
            int r = (int) (Math.random() * n);
            // 获取此随机数索引位置的元素
            result[i] = numbers[r];
            // 移动最后一个元素到随机数索引位置
            numbers[r] = numbers[n-1];
            n--;
        }
        
        // 打印排序数组
        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        for (int r : result) {
            System.out.println(r);
        }
    }    
    
}
