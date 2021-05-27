import java.util.Scanner;

public class addStaffTool {
    static Scanner input = HumanResource.input;
    static Department department;
    public static void menu() {
        System.out.println("Do you want add new Employee or Manager?");
        HumanResource.lineBreak();
        System.out.println("1. Manager");
        System.out.println("2. Employee");
        System.out.println("3. Exit");
        HumanResource.lineBreak();
        System.out.print("Your choice: ");
    }

    public static Department departmentHelper() {
        System.out.println("Department (Choice by Number)");
        System.out.println("\t1. Administrator");
        System.out.println("\t2. Business");
        System.out.println("\t3. Marketer");
        System.out.println("\t4. Engineering");
        HumanResource.lineBreak();
        System.out.print("Your choice: ");
        int departmentChoice = Integer.parseInt(input.nextLine());
        if (departmentChoice == 1) {
            return Database.administrator;
        } else if (departmentChoice == 2) {
            return Database.business;
        } else if (departmentChoice == 3) {
            return Database.marketing;
        } else return Database.engineering;
    }

    public static String idHelper(Department department, boolean isManager) {
        boolean isDuplicate;
        String id;
        do {
            isDuplicate = false;
            if (department == Database.administrator) id = "1";
            else if (department == Database.business) id = "2";
            else if (department == Database.marketing) id = "3";
            else id = "4";

            if (isManager) id += "0";
            else id+= "1";

            System.out.print("ID (only 2 last number): ");
            String ownID = input.nextLine();
            id += ownID;

            for (Staff staff : HumanResource.staffList) {
                if (staff.getId().equals(id)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Duplicate ID, please try again!");
            }
        } while (isDuplicate);
        return id;
    }

    public static String managerTitleHelper() {
        System.out.print("Enter title: ");
        String titleChoice = input.nextLine();
        if (titleChoice.toLowerCase().contains("business")) return "Business Leader";
        if (titleChoice.toLowerCase().contains("technical")) return "Technical Leader";
        if (titleChoice.toLowerCase().contains("project")) return "Project Leader";
        return titleChoice;
    }

    public static void manager() {
        department = departmentHelper();
        department.addStaff();
        System.out.println();

        String id = idHelper(department, true);

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Salary factor: ");
        double salaryFactor = Double.parseDouble(input.nextLine());

        int date = 2021;

        int leaveDay = 0;

        String title = managerTitleHelper();

        HumanResource.staffList.add(new Manager(id, name, age, salaryFactor, date, department, leaveDay, title));
    }

    public static void employee() {
        department = departmentHelper();
        System.out.println();

        String id = idHelper(department, false);

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Salary factor: ");
        double salaryFactor = Double.parseDouble(input.nextLine());

        int date = 2021;

        int leaveDay = 0;

        int ot = 0;

        HumanResource.staffList.add(new Employee(id, name, age, salaryFactor, date, department, leaveDay, ot));
    }

}
