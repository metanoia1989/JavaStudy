import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Objects;

public class tree_set_test {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>(); 
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(args);
        
        SortedSet<Item> sortByDescription = new TreeSet<>(new 
            Comparator<Item>()  {
                public int compare(Item a, Item b)
                {
                    String descrA = a.getDescription();    
                    String descrB = b.getDescription();    
                    return descrA.compareTo(descrB);
                }
            }
        );
        
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}


class Item implements Comparable<Item>
{
    private String description; 
    private int partNumber; 
    
    /**
     * Item的构造函数
     *
     * @param aDescription
     * @param aPartNumber
     */
    public Item(String aDescription, int aPartNumber)
    {
        description = aDescription;   
        partNumber = aPartNumber;
    }
    
    /**
     * 获取item的描述
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;    
    }
    
    public String toString()
    {
        return "[description=" + description + ", partNumber=" + partNumber + "]";    
    }
    
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) {
            return true;
        }     
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Item other = (Item) otherObject;
        return description.equals(other.description) && partNumber == other.partNumber;
    }
    
    public int hashCode()
    {
        return Objects.hash(description, partNumber);
    }
    
    public int compareTo(Item other)
    {
        return Integer.compare(partNumber, partNumber);    
    }
}