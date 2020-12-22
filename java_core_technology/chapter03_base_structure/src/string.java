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
        
        // 修改字符串
        greeting = greeting.substring(0, 3) + "p!";
        System.out.println(String.format("修改字符串 %s", greeting));
        
        // 字符串相等判断
        System.out.println(String.format("字符串是否相等 %b", "Hello".equals(greeting)));
        System.out.println(String.format("字符串是否相等 不区分大小写 %b", "Hello".equalsIgnoreCase("hello")));
        
        // 空串 和 null 值
        String str = "";
        System.out.println(String.format("str 是否为null值 %b", str == null));
        System.out.println(String.format("str 是否为空串 %b", str.length() == 0 || str.equals("")));
        
        // 代码点和代码单元
        greeting = "hello";
        System.out.println(String.format("greeting 的代码单元数量为 %d", greeting.length()));
        System.out.println(String.format("greeting 的代码点数量为 %d", greeting.codePointCount(0, greeting.length())));
        char first = greeting.charAt(0); 
        char last = greeting.charAt(4); 
        System.out.println(String.format("输出两个代码单元 %c %c", first, last));

        // 获取第i个代码点
        greeting = "你好哈哈哈";
        int index = greeting.offsetByCodePoints(0, 4);
        int cp = greeting.codePointAt(index);
        System.out.println(String.format("你好哈哈哈第4个代码点是 %c", cp));
        
        // StringBuilder 类的使用
        StringBuilder builder = new StringBuilder();
        builder.append('c'); // 添加单个字符 
        builder.append(" hello"); // 追加一个字符串
        String completedString = builder.toString(); // 输出字符序列
        System.out.println("通过builder构建的字符串：" + completedString);
    }
}
