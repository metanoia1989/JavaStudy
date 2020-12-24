import java.util.Map;
import java.util.HashMap;

public class map_test {
    public static void main(String[] args) {
        Map<String, Employee2> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee2("Amy Lee", 122));
        staff.put("567-24-2546", new Employee2("Harry Hacker", 101));
        staff.put("157-62-7935", new Employee2("Gary Cooper", 144));
        staff.put("456-62-5527", new Employee2("Francesca Cruz", 135));
        
        System.out.println(staff); // 打印所有键值
        staff.remove("567-24-2546"); // 移除一个键值对
        staff.put("456-62-5527", new Employee2("Francesca Miller", 245)); // 替换一个键值 
        System.out.println(staff.get("157-62-7935")); // 查看一个键值
        
        // 迭代所有的键值对
        for (Map.Entry<String, Employee2> entry: staff.entrySet()) {
            String key = entry.getKey(); 
            Employee2 value = entry.getValue();
            System.out.println("key=" + key + ",value = " + value);
        }
    }    
}

class Employee2 {
    private int bonus;
    private String name;
    
    public Employee2() { bonus = 0; name = ""; }
    public Employee2(String name, int bonus) { this.name = name; this.bonus = bonus; }
    
    public int getBonus() { return bonus; }
    public String getName() { return name; }
    
    public void setBonus(int newBonus)  { bonus = newBonus; }
    public void setName(String newName)  { name = newName; }
}
