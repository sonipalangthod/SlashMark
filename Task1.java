import java.util.ArrayList;
import java.util.Scanner;

public class Task1{
    private ArrayList<String> tasks;
    private Scanner scanner;

    public Task1() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void start() {
        System.out.println("Welcome to the Task List Application!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    addTask(taskToAdd);
                    break;
                case 2:
                    if (!tasks.isEmpty()) {
                        System.out.print("Enter index of task to remove: ");
                        int indexToRemove = scanner.nextInt() - 1;
                        removeTask(indexToRemove);
                    } else {
                        System.out.println("Task list is empty.");
                    }
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Task1 app = new Task1();
        app.start();
    }
}
