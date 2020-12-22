public class string {
    public static void main(String[] args) throws Exception {
        String e = ""; // 空字符串 
        String greeting = "Hello"; 
        String sub = greeting.substring(0, 3);
        System.out.println(String.format("%s的子串：%s", greeting, sub));
        
        // 字符串拼接
        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;
        System.out.println(String.format("字符串拼接 %s+%s=%s", expletive, PG13, message));
    }
}
