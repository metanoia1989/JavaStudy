import java.io.Console;

public class read_password {
    public static void main(String[] args) throws Exception{
        Console cons = System.console(); 
        String username = cons.readLine("你的名字：");
        char[] password = cons.readPassword("请输入密码：");
        
        // 输出内容到控制台
        System.out.println(username + " 输出密码了" + new String(password));
    }    
}
