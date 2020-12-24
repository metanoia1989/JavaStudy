import java.util.Scanner;

public class enum_test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input); // 从字符串创建枚举类
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) { // 枚举类的比较直接用等号就好   
            System.out.println("Good job--you paid attention to the _.");
        }
    }
}

enum Size
{
    SMALL("S"), MEDIUM("M"), LARGE("L") , EXTRA_LARGE("XL");  
    
    private Size(String abbreviation) { this.abbreviation = abbreviation; }
    public String getAbbreviation() { return abbreviation; }
    
    private String abbreviation;
}
