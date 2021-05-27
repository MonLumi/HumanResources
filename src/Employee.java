public class Employee extends Staff implements ICalculator{
    private int overtimeHours;

    public Employee(String id, String name, int age, double factor, int date, Department department, int leaveDays, int ot) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryFactor = factor;
        this.entryDate = date;
        this.department = department;
        this.leaveDays = leaveDays;
        this.overtimeHours = ot;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "overtimeHours=" + overtimeHours +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salaryFactor=" + salaryFactor +
                ", entryDate=" + entryDate +
                ", Department='" + department + '\'' +
                ", leaveDays=" + leaveDays +
                '}';
    }

    @Override
    public int calculateSalary() {
        int overtimeBonus = overtimeHours*200000;
        return (int)(salaryFactor*3000000) + overtimeBonus;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", id, name, age, entryDate, department);
    }

    @Override
    public void payrollDisplay() {
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", id, name, department, "",calculateSalary());
    }
}
