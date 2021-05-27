import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class searchTool {

    static Scanner input = HumanResource.input;
    static List<Staff> searchResult = new ArrayList<>();

    public static void menu() {
        System.out.println("Do you want search Staff by name or ID?");
        HumanResource.lineBreak();
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Exit");
        HumanResource.lineBreak();
        System.out.print("Your choice: ");
    }

    public static void id() {
        System.out.print("Search ID: ");
        String id = input.nextLine();
        boolean isExist = false;
        for (Staff staff : HumanResource.staffList) {
            if (staff.getId().equals(id)) {
                isExist = true;
                System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%n", "ID", "NAME", "AGE", "ENTRY DATE",
                        "DEPARTMENT", "TITLE");
                HumanResource.lineBreak();
                staff.displayInformation();
                break;
            }
        }
        if (!isExist) {
            System.out.println("The Staff's ID isn't exist");
        }
    }

    public static void name() {
        System.out.print("Search Name: ");
        String name = input.nextLine().toLowerCase();
        boolean isExist = false;
        for (Staff staff : HumanResource.staffList) {
            if (staff.getName().toLowerCase().contains(name)) {
                searchResult.add(staff);
                isExist = true;
            }
        }

        if (isExist) {
            System.out.println("We found " + searchResult.size() + " Staffs that contain this name: ");
            System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%n", "ID", "NAME", "AGE", "ENTRY DATE",
                    "DEPARTMENT", "TITLE");
            HumanResource.lineBreak();
            for (Staff available : searchResult) {
                available.displayInformation();
            }
        } else {
            System.out.println("We don't find any Staff has the name: " + name);
        }
    }

    public static void clearOldSearch() {
        searchResult.clear();
    }
}
