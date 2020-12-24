public class variable_parameter {
    public static void main(String[] args) {
        print("hello", "worlds", "呼呼呼呼");
    } 
    
    public static void print(String... args)
    {
        System.out.println(String.join(",", args));    
    }
}
