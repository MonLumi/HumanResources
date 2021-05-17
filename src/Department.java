import java.util.ArrayList;
import java.util.List;

public class Department implements IDisplayInfo{
    private final String id;
    private final String name;
    private int totalEmployees;

    public Department (String id, String name) {
        this.id = id;
        this.name = name;
        this.totalEmployees = 0;
    }

    public void addStaff() {
        totalEmployees++;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalEmployees=" + totalEmployees +
                '}';
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-10s%-20s%-20s%n", id, name, totalEmployees);
    }

}
