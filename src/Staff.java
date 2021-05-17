public abstract class Staff implements IDisplayInfo{
    int id;
    String name;
    int age;
    double salaryFactor;
    int entryDate;
    Department department;
    int leaveDays;

    public Department getDepartment() {
        return department;
    }

    @Override
    public abstract String toString();

    public abstract void displayInformation();


}
