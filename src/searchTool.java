import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        ArrayList<Staff> availableStaff = new ArrayList<>();
        boolean isExist = false;
        for (Staff staff : HumanResource.staffList) {
            if (staff.getName().toLowerCase().contains(name)) {
                availableStaff.add(staff);
                isExist = true;
            }
        }

        if (isExist) {
            System.out.println("We found " + availableStaff.size() + " Staffs");
            for (Staff available : availableStaff) {
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
