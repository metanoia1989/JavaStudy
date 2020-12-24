import java.util.Date;
import java.util.GregorianCalendar;

public class clone_test {
    public static void main(String[] args) {
        try {
            EmployeeClone original = new EmployeeClone("John Q. Public", 50000); 
            original.setHireDay(2000, 1, 1);
            EmployeeClone copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }    
}

class EmployeeClone implements Comparable<EmployeeClone>, Cloneable
{
    private String name; 
    private double salary;
    private Date hireDay;
    
    public EmployeeClone(String aName, double aSalary)
    {
        name = aName;     
        salary = aSalary;
        hireDay = new Date();
    }
    
    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;    
    }
    
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100; 
        salary += raise;
    }
    
    /**
     * Set the hire day to a give date
     * @param year
     * @param month
     * @param day
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime(); 
        hireDay.setTime(newHireDay.getTime());
    }
    
    public int compareTo(EmployeeClone other) {
        return Double.compare(salary, other.salary); 
    }
    
    public EmployeeClone clone() throws CloneNotSupportedException
    {
        EmployeeClone cloned = (EmployeeClone) super.clone();    
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }
    
    public String toString() {
        return "Employee[name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]"; 
    }
}