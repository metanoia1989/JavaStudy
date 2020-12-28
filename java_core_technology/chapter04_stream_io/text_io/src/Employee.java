import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>, Cloneable, Serializable
{
    private String name; 
    private double salary;
    private Date hireDay;
    
    public static int NAME_SIZE = 20;
    
    public Employee(String aName, double aSalary)
    {
        name = aName;     
        salary = aSalary;
        hireDay = new Date();
    }

    public Employee(String aName, double aSalary, int year, int month, int day)
    {
        name = aName;     
        salary = aSalary;
        hireDay = new Date();
        setHireDay(year, month, day);
    }
    
    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;    
    }
    
    public Date getHireDay() {
        return hireDay; 
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
    
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary); 
    }
    
    public Employee clone() throws CloneNotSupportedException
    {
        Employee cloned = (Employee) super.clone();    
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }
    
    public String toString() {
        return "Employee[name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]"; 
    }
}