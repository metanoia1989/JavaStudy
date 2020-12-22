import java.math.BigInteger;
import java.util.Scanner;

public class big_integer_test {
    /** 
     * 大数值运算测试
     * 假设你被邀请参加抽奖活动，并从490个可能的数值中抽取60个，中奖倍率是多少  
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        System.out.print("How many nubmers do you need do draw？");
        int k = in.nextInt();

        System.out.print("What is the hightest nubmer you can draw？");
        int n = in.nextInt();
         
        // compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3...*k)
        BigInteger lotteryOdds = BigInteger.valueOf(1); 
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(
                BigInteger.valueOf(i)
            );
            System.out.println("Your odds are 1 in " + lotteryOdds + ", Good luck!");
        }
    }    
}
