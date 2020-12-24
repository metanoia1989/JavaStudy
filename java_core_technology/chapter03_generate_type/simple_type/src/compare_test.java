import java.util.GregorianCalendar;
import java.util.Calendar;

class ArrayAlg2
{
    public static <T extends Comparable<T>> Pair<T> minmax(T[] a) 
    {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
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
    
    public static <T> void print(T arg)
    {
        System.out.println(arg);
    }

}

public class compare_test {
    public static void main(String[] args) {
        GregorianCalendar[] brithdays = {
            new GregorianCalendar(1906, Calendar.DECEMBER, 9), // G. Hopper
            new GregorianCalendar(1815, Calendar.DECEMBER, 10), // A. Lovelace
            new GregorianCalendar(1903, Calendar.DECEMBER, 3), // J. von Neumann
            new GregorianCalendar(1910, Calendar.JUNE, 22), // K. Zuse
        };    
        Pair<Calendar> mm = ArrayAlg2.minmax(brithdays);
        System.out.println("min = " + mm.getFirst().getTime());
        System.out.println("max = " + mm.getSecond().getTime());
        
        ArrayAlg2.print(1234);
    }
}
