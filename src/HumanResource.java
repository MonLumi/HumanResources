import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanResource {

    static List<Staff> staffList = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Database.setStaffList();


        int choice;
        do {
            menu();
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                // Display staff
                case 1 -> {
                    System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%n", "ID", "NAME", "AGE", "ENTRY DATE",
                            "DEPARTMENT", "TITLE");
                    for (Staff staff : staffList) {
                        staff.displayInformation();
                    }
                }
                // Display department
                case 2 -> {
                    System.out.println("Company's Departments: ");
                    lineBreak();
                    Database.administrator.displayInformation();
                    Database.business.displayInformation();
                    Database.marketing.displayInformation();
                    Database.engineering.displayInformation();
                    lineBreak();
                    System.out.print("Press Enter to go back!");
                    input.nextLine();
                }
                // Display staff by department
                case 3 -> {
                    int isRepeat;
                    do {
                        System.out.println("Choice which Department you want to display");
                        lineBreak();
                        System.out.println("1. Administrator");
                        System.out.println("2. Business");
                        System.out.println("3. Marketing");
                        System.out.println("4. Engineering");
                        System.out.println("5. Go back");
                        lineBreak();
                        System.out.print("Your choice: ");
                        int departmentChoice = Integer.parseInt(input.nextLine());

                        while (departmentChoice < 5) {
                            // Set null to avoid error;
                            Department display = null;
                            switch (departmentChoice) {
                                case 1 -> display = Database.administrator;
                                case 2 -> display = Database.business;
                                case 3 -> display = Database.marketing;
                                case 4 -> display = Database.engineering;
                            }
                            System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%n", "ID", "NAME", "AGE", "ENTRY DATE",
                                    "DEPARTMENT", "TITLE");
                            for (Staff staff : staffList) {
                                if (staff.getDepartment() == display) staff.displayInformation();
                            }
                        }
                        System.out.print("Do you want to display another Department? (\"1\" for Yes): ");
                        isRepeat = Integer.parseInt(input.nextLine());
                        System.out.println();
                    } while (isRepeat == 1);
                }
                // Add staff
                case 4 -> {
                    int addChoice;
                    do {
                        addStaffTool.menu();
                        addChoice = Integer.parseInt(input.nextLine());
                        if (addChoice == 1) {
                            addStaffTool.manager();
                        } else if (addChoice == 2) {
                            addStaffTool.employee();
                        } else break;

                        System.out.print("Do you want to add another Staff? (\"1\" for Yes: )");
                        addChoice = Integer.parseInt(input.nextLine());
                    } while (addChoice < 3);
                }
                // Search staff
                case 5 -> {
                    int searchChoice;
                    do {
                        searchTool.clearOldSearch();
                        searchTool.menu();
                        searchChoice = Integer.parseInt(input.nextLine());
                        switch (searchChoice) {
                            // Search by ID
                            case 1 -> {}
                            // Search by name
                            case 2 -> {}
                        }

                    } while (searchChoice < 3);
                }
                // Display payroll
                case 6 -> {}
            }
            lineBreak();
            if (choice < 7) {
                System.out.print("Continue (\"1\" for Yes): ");
                choice = Integer.parseInt(input.nextLine());
            }
        } while (choice < 7);
        System.out.println("Thanks, see you later!");
    }

    public static void menu() {
        System.out.println("Welcome to HR manager");
        lineBreak();
        System.out.println("1. Display company's staffs");
        System.out.println("2. Display company's departments");
        System.out.println("3. Display staffs by departments");
        System.out.println("4. Add new staff");
        System.out.println("5. Search staff by ID or Name");
        System.out.println("6. Display company's payroll");
        System.out.println("7. Exit");
        lineBreak();
        System.out.print("Your choice: ");
    }

    public static void lineBreak() {
        System.out.println("------------------");
    }

}
