public class serial_clone_test {
    public static void main(String[] args) {
        try {
            Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1); 
            Employee harry2 = (Employee) harry.clone();
            harry.raiseSalary(10);
            
            System.out.println(harry);
            System.out.println(harry2);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
