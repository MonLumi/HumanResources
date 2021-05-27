import java.util.List;


public class displayPayroll {

    private static List<Staff> staffPayroll = HumanResource.staffList.subList(0, HumanResource.staffList.size()-1);

    public static void menu() {
        System.out.println("Do you want display Company's payroll by which oder?");
        HumanResource.lineBreak();
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.println("3. Exit");
        HumanResource.lineBreak();
        System.out.print("Your choice: ");
    }

    public static void ascendingOrder() {
        staffPayroll.sort((o1, o2) -> (o1.calculateSalary() <= o2.calculateSalary()) ? 1 : -1);
        for (Staff staff : staffPayroll) staff.payrollDisplay();
    }

    public static void descendingOrder() {
        staffPayroll.sort((o1, o2) -> (o1.calculateSalary() >= o2.calculateSalary()) ? 1 : -1);
        for (Staff staff : staffPayroll) staff.payrollDisplay();
    }
}
