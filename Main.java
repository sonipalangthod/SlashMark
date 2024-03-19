import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String id;
    private String name;
    private String department;

    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

public class Main {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Employee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    viewAllEmployees();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting Employee Management Application.");
    }

    private static void addEmployee() {
        System.out.println("Enter employee details:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();

        employees.add(new Employee(id, name, department));
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployee() {
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        Employee employee = findEmployee(id);
        if (employee != null) {
            System.out.println("Employee details:");
            System.out.println(employee);
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        Employee employee = findEmployee(id);
        if (employee != null) {
            System.out.println("Enter new details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            employee.setName(name);
            employee.setDepartment(department);
            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        Employee employee = findEmployee(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("List of all employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static Employee findEmployee(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
}
