import java.util.Arrays;

public class compare_interface_test {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];        

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);
        
        Arrays.sort(staff); 
        
        // print out informationj about all Employee objects
        for (Employee e : staff) {
            System.out.println("name="+e.getName() + ", salary=" + e.getSalary()); 
        } 
    }    
}

class Employee implements Comparable<Employee>, Cloneable
{
    private String name; 
    private double salary;
    
    public Employee(String aName, double aSalary)
    {
        name = aName;     
        salary = aSalary;
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
    
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary); 
    }
    
    public Employee clone() throws CloneNotSupportedException
    {
        Employee cloned = (Employee) super.clone();    

        return cloned;
    }
}