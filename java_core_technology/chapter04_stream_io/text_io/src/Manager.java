
public class Manager extends Employee {
    private Employee secretary;
    
    public Manager(String aName, double aSalary) {
        super(aName, aSalary); 
    }

    public Manager(String aName, double aSalary, int year, int month, int day) {
        super(aName, aSalary, year, month, day);
    }

    public void setSecretary(Employee employee) {
        secretary = employee;
    }
    
    public Employee getSecretaryName() {
        return secretary; 
    }
}
