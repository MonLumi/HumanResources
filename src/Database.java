public class Database {
    // Default database
    static Department administrator = new Department("D01", "Administrator");
    static Department business = new Department("D02", "Business");
    static Department marketing = new Department("D03", "Marketing");
    static Department engineering = new Department("D04", "Engineer");

    //Create Manager
    static Manager M1 = new Manager("1001", "Anh", 26, 7.22, 1995, administrator, 26, "CEO");
    static Manager M2 = new Manager("2001", "Vu", 29, 4.75, 2013, business, 26, "Business Leader");
    static Manager M3 = new Manager("3001", "Ly", 29, 4.45, 2017, marketing, 20, "Project Leader");
    static Manager M4 = new Manager("4001", "Hai", 36, 5.54, 2019, engineering, 26, "Technical Leader");
    static Manager M5 = new Manager("1002", "Tuan", 49, 3.08, 2013, administrator, 15, "Security Chief");
    static Manager M6 = new Manager("1003", "Phong", 35, 6.5, 2000, administrator, 24, "Chief Accountant");

    //Create Employee
    static Employee E1 = new Employee("4101", "Hoang", 26, 5.93, 2019, engineering, 12, 40);
    static Employee E2 = new Employee("4102", "Viet", 24, 4.34, 2021, engineering, 12, 34);
    static Employee E3 = new Employee("4103", "Tuan", 25, 4.56, 2020, engineering, 10, 37);
    static Employee E4 = new Employee("2101", "Tien", 27, 4.48, 2018, business, 5, 3);
    static Employee E5 = new Employee("1101", "Thu", 28, 6.69, 2020, administrator, 0, 80);
    static Employee E6 = new Employee("3101", "Thuy", 33, 7.44, 2015, marketing, 12, 20);



    public static void setStaffList() {
        // first for Manager
        HumanResource.staffList.add(M1);
        HumanResource.staffList.add(M2);
        HumanResource.staffList.add(M3);
        HumanResource.staffList.add(M4);
        HumanResource.staffList.add(M5);
        HumanResource.staffList.add(M6);

        // now for Employee
        HumanResource.staffList.add(E1);
        HumanResource.staffList.add(E2);
        HumanResource.staffList.add(E3);
        HumanResource.staffList.add(E4);
        HumanResource.staffList.add(E5);
        HumanResource.staffList.add(E6);

        // update department's Staff count
        for (Staff staff : HumanResource.staffList) {
            staff.getDepartment().addStaff();
        }
    }

}
