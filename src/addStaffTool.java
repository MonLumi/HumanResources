import java.util.Scanner;

public class addStaffTool {
    static Scanner input = HumanResource.input;

    public static void menu() {
        System.out.println("This tool for only the Boss, go back if you're not!");
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
        int departmentChoice = Integer.parseInt(input.nextLine());
        if (departmentChoice == 1) {
            return Database.administrator;
        } else if (departmentChoice == 2) {
            return Database.business;
        } else if (departmentChoice == 3) {
            return Database.marketing;
        } else return Database.engineering;
    }

    public static int idHelper(Department department, boolean isManager) {
        boolean isDuplicate = false;
        int id;
        do {
            System.out.print("ID: ");
            String idString;
            if (department == Database.administrator) idString = "1";
            else if (department == Database.business) idString = "2";
            else if (department == Database.marketing) idString = "3";
            else idString = "4";

            if (isManager) idString.concat("0");
            else idString.concat("1");

            idString.concat(input.nextLine());
            id = Integer.parseInt(idString);


            for (Staff staff : HumanResource.staffList) {
                if (staff.getId() == id) {
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
        System.out.println("Chose a title below");
        HumanResource.lineBreak();
        System.out.println("1. Business Leader");
        System.out.println("2. Technical Leader");
        System.out.println("3. Project Leader");
        System.out.println("4. Other");
        HumanResource.lineBreak();
        System.out.print("Title: ");
        int titleChoice = Integer.parseInt(input.nextLine());
        if (titleChoice == 1) return "Business Leader";
        if (titleChoice == 2) return "Technical Leader";
        if (titleChoice == 3) return "Project Leader";
        return "";
    }


    public static void manager() {
        Department department = departmentHelper();
        System.out.println();

        int id = idHelper(department, true);

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();

        System.out.print("Salary factor: ");
        double salaryFactor = input.nextDouble();

        int date = 2021;

        int leaveDay = 0;

        String title = managerTitleHelper();

        HumanResource.staffList.add(new Manager(id, name, age, salaryFactor, date, department, leaveDay, title));
    }

    public static void employee() {
        Department department = departmentHelper();
        System.out.println();

        int id = idHelper(department, false);

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();

        System.out.print("Salary factor: ");
        double salaryFactor = input.nextDouble();

        int date = 2021;

        int leaveDay = 0;

        int ot = 0;

        HumanResource.staffList.add(new Employee(id, name, age, salaryFactor, date, department, leaveDay, ot));
    }



}
