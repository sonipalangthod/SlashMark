import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Functionality 1: Generating a Password
        System.out.println("Generate a Password:");
        String password = generatePassword(scanner);
        System.out.println("Generated Password: " + password);

        // Functionality 2: Checking Password Strength
        System.out.println("\nCheck Password Strength:");
        int score = checkPasswordStrength(password);
        displayStrengthMessage(score);

        // Functionality 3: Display Useful Information
        displayUsefulInformation();
        
        scanner.close();
    }

    public static String generatePassword(Scanner scanner) {
        StringBuilder password = new StringBuilder();
        String passwordAlphabet = "";

        // Ask user for password criteria
        System.out.print("Use uppercase letters? (Yes/No): ");
        if (scanner.nextLine().equalsIgnoreCase("Yes")) {
            passwordAlphabet += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }

        System.out.print("Use lowercase letters? (Yes/No): ");
        if (scanner.nextLine().equalsIgnoreCase("Yes")) {
            passwordAlphabet += "abcdefghijklmnopqrstuvwxyz";
        }

        System.out.print("Use numbers? (Yes/No): ");
        if (scanner.nextLine().equalsIgnoreCase("Yes")) {
            passwordAlphabet += "0123456789";
        }

        System.out.print("Use symbols? (Yes/No): ");
        if (scanner.nextLine().equalsIgnoreCase("Yes")) {
            passwordAlphabet += "!@#$%^&*()-_+=<>?";
        }

        System.out.print("Enter desired length of the password: ");
        int length = scanner.nextInt();

        // Generate password
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * passwordAlphabet.length());
            password.append(passwordAlphabet.charAt(randomIndex));
        }

        return password.toString();
    }

    public static int checkPasswordStrength(String password) {
        int score = 0;

        // Criteria 1: Uppercase letters
        if (password.matches(".*[A-Z].*")) {
            score += 2;
        }

        // Criteria 2: Lowercase letters
        if (password.matches(".*[a-z].*")) {
            score += 2;
        }

        // Criteria 3: Numbers
        if (password.matches(".*[0-9].*")) {
            score += 2;
        }

        // Criteria 4: Symbols
        if (password.matches(".*[!@#$%^&*()-_+=<>?].*")) {
            score += 2;
        }

        // Criteria 5: Length >= 8
        if (password.length() >= 8) {
            score += 2;
        }

        // Criteria 6: Length >= 16
        if (password.length() >= 16) {
            score += 2;
        }

        return score;
    }

    public static void displayStrengthMessage(int score) {
        if (score <= 4) {
            System.out.println("Password strength: Weak");
        } else if (score <= 8) {
            System.out.println("Password strength: Medium");
        } else if (score <= 12) {
            System.out.println("Password strength: Good");
        } else {
            System.out.println("Password strength: Great");
        }
    }

    public static void displayUsefulInformation() {
        System.out.println("\nUseful Information:");
        System.out.println("- Avoid using the same password for multiple accounts.");
        System.out.println("- Avoid character repetition (e.g., 'aaaaaa').");
        System.out.println("- Avoid keyboard patterns (e.g., 'qwerty').");
        System.out.println("- Avoid dictionary words.");
        System.out.println("- Avoid letter or number sequences (e.g., '123456' or 'abcdef').");
    }
}
