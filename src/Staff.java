public abstract class Staff implements IDisplayInfo, ICalculator{
    String id;
    String name;
    int age;
    double salaryFactor;
    int entryDate;
    Department department;
    int leaveDays;

    public Department getDepartment() {
        return department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();

    public abstract void displayInformation();

    public abstract void payrollDisplay();

    @Override
    public abstract int calculateSalary();
}
