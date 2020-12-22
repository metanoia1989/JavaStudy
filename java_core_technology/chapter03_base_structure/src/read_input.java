import java.util.Scanner;

public class read_input {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        
        // 获取第一个输入
        System.out.print("你的名字是什么？");
        String name = in.nextLine();
        
        // 获取第二个输入
        System.out.print("你的年龄是多少哦？");
        int age = in.nextInt();
        
        // 获取第三个输入
        System.out.print("您现在的存款是多少？");
        double money = in.nextDouble();
        
        // 输出内容到控制台
        System.out.println(String.format("您好，%s。明年你的年龄是 %d。你当前的存款 %f", name, age, money));
    }    
}
