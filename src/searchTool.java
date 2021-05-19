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
        int id = Integer.parseInt(input.nextLine());

    }

    public static void clearOldSearch() {
        searchResult.clear();
    }
}
