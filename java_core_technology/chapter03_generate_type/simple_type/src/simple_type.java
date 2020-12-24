import java.lang.reflect.Array;

class ArrayAlg
{
    public static Pair<String> minmax(String[] a) 
    {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
    
    public static <T> T getMiddle(T... a)
    {
        return a[a.length / 2];    
    }
    
    public static <T extends Comparable<T>> T min(T[] a)
    {
        if (a == null || a.length == 0) {
            return null;
        }    
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0)  {
                smallest = a[i]; 
            }
        }
        return smallest;
    }
    
    public static <T> Pair<T> makePair(Class<T> cl)
    {
        try {
            return new Pair<>(cl.getDeclaredConstructor().newInstance(), cl.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            return null;
        }    
    }
}


public class simple_type {
    public static void main(String[] args) throws Exception {
        String[] words = { "Mary", "had", "a", "little", "lamb" };
        Pair<String> mm = ArrayAlg.minmax(words);
        String middle = ArrayAlg.getMiddle("John", "Q.", "Public"); // 编译器自动推导类型
        String middle2 = ArrayAlg.<String>getMiddle("John", "Q.", "Public"); // 完成的调用写法
        String small = ArrayAlg.min(words);

        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
        System.out.println("middle = " + middle);
        System.out.println("middle2 = " + middle2);
        System.out.println("small = " + small);
        
        // 测试运行类型查询
        Pair<String> a = null;
        Pair<Integer> b = null;
        if (a instanceof Pair<?>) {
            System.out.println("instanceof Pair<?>");
        } else {
            System.out.println("not instanceof Pair<?>"); 
        }
        // if (a.getClass() == b.getClass()) { // 不能调用哈，直接报错了    
        //     System.out.println("Pair<String>.getClass() == Pair<Integer>.getClass()"); 
        // }
        // Pair<String> c = (Pair<String>)b; // 也不行
        
        // 获取类型的实例
        Pair<String> instance = ArrayAlg.makePair(String.class);
    }
}
