import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/** 
 * 好像没啥乱用!
 */
public class random_access 
{
    public static void main(String[] args) {
        Employee[] staff = new Employee[3]; 
        
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))) {
            // save all employee records to the file employee.dat 
            for (Employee e : staff) {
                writeData(out, e); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes employee data to a data output
     * @param out the data output
     * @param e the employee
     */
    public static void writeData(DataOutput out, Employee e) throws IOException 
    {
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH) + 1);
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }
    
    /**
     * Reads employee data from a data input
     * 
     * @param in the data input
     * @return the employee
     */
    public static Employee readData(DataInput in) throws IOException 
    {
        String name =  DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m-1, d);
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