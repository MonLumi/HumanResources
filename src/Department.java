public class Department implements IDisplayInfo{
    private final String id;
    private final String name;
    private int totalStaffs;

    public Department (String id, String name) {
        this.id = id;
        this.name = name;
        this.totalStaffs = 0;
    }

    public void addStaff() {
        totalStaffs++;
    }

    public int getTotalStaffs() {
        return totalStaffs;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-10s%-20s%-20s%n", id, name, totalStaffs);
    }

}
