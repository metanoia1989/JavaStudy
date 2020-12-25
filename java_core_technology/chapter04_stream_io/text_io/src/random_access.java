import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class random_access {

    public static void writeData(DataOutput out, Employee e) throws IOException {

    }
    
    public static Employee readData(DataInput in) throws IOException {
        String name =  DataIO.readFixedString(Employee.NAME_SIZE, in)
    }
}


class DataIO
{
    public static String readFixedString(int size, DataInput in) throws IOException {
        StringBuffer b = new StringBuffer(size);           
        int i = 0;
        boolean more = true;
        while (more && i < size) {
            char ch = in.readChar();
            i++;
            if (ch == 0) {
                more = false;
            } else {
                b.append(ch);
            }
        }
        in.skipBytes(2 * (size - 1));
        return b.toString();
    } 
    
    public static void writeFixedString(String s, int size, DataOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
            char ch = 0; 
            if (i < s.length()) {
                ch = s.charAt(i);
            }
            out.writeChar(ch);
        }
    }
}