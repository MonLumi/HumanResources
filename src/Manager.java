public class Manager extends Staff implements ICalculator{
    private String title;
    private int bonus;

    public Manager(String id, String name, int age, double factor, int entry, Department department, int leaveDays, String title) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryFactor = factor;
        this.entryDate = entry;
        this.department = department;
        this.leaveDays = leaveDays;
        this.title = title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBonus(String title) {
        if (title.contains("Business")) bonus = 8000000;
        if (title.contains("Project")) bonus = 5000000;
        if (title.contains("Technical")) bonus = 6000000;
        if (title.equals("CEO")) {
            System.out.println("He is the Boss, he doesn't need salary :))");
        }
        bonus = 3000000;
    }

    public void updateBonus() {
        this.bonus = HumanResource.input.nextInt();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "title='" + title + '\'' +
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
        return (int)(5000000*salaryFactor) + bonus;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%n", id, name, age, entryDate, department, title);
    }

    @Override
    public void payrollDisplay() {
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", id, name, department, title, calculateSalary());
    }
}
