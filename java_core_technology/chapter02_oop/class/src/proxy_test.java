import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class proxy_test {
    public static void main(String[] args) {
        Object[] elements = new Object[1000]; 
        
        // fill elements with proxies for the integers 1 ... 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1; 
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{ Comparable.class }, handler);
            elements[i] = proxy;
        }
        
        // 构造一个随机整数
        Integer key = new Random().nextInt(elements.length) + 1;
        
        // 搜索关键字
        int result = Arrays.binarySearch(elements, key);
        
        // 打印匹配的
        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

/** 
 * An invocation handler that prints out the method name and parameters,
 * then invokes the original method
 */
class TraceHandler implements InvocationHandler
{
    private Object target; 
    
    /**
     * Constructs a TraceHandler
     * @param t the implicit parameter of the method call
     */
    public TraceHandler(Object t)
    {
        target = t; 
    }
    
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("."+m.getName()+"(");
        
        // print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]); 
                if (i < args.length - 1) {
                    System.out.print(", ");        
                }
            }
        }
        System.out.println(")");
        
        // invoke actual method
        return m.invoke(target, args);
    }
}