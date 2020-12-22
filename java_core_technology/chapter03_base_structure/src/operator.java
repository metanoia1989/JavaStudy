public class operator {
    public static double square_root(double value)
    {
        return Math.sqrt(value); 
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(String.format("4的平方根为：%f", square_root(4)));
        System.out.println(String.format("2的3次幂：%f", Math.pow(2, 3)));
    }
}
