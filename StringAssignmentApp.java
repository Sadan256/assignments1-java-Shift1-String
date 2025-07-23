import java.util.Scanner;

public class StringAssignmentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringUtility utility = new StringUtility();
        String inputString;

        System.out.print("Enter a string: ");
        inputString = scanner.nextLine();

        int choice;
        do {
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. Count vowels and consonants");
            System.out.println("2. Check if palindrome");
            System.out.println("3. Reverse the string");
            System.out.println("4. Convert to uppercase and lowercase");
            System.out.println("5. Replace a word in the string");
            System.out.println("6. Enter a new string");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    int vowels = utility.countVowels(inputString);
                    int consonants = utility.countConsonants(inputString);
                    System.out.println("Vowels: " + vowels);
                    System.out.println("Consonants: " + consonants);
                    break;
                case 2:
                    boolean palindrome = utility.isPalindrome(inputString);
                    System.out.println("Is palindrome? " + (palindrome ? "Yes" : "No"));
                    break;
                case 3:
                    System.out.println("Reversed string: " + utility.reverseString(inputString));
                    break;
                case 4:
                    System.out.println("Uppercase: " + utility.toUpperCase(inputString));
                    System.out.println("Lowercase: " + utility.toLowerCase(inputString));
                    break;
                case 5:
                    System.out.print("Enter word to replace: ");
                    String oldWord = scanner.nextLine();
                    System.out.print("Enter new word: ");
                    String newWord = scanner.nextLine();
                    inputString = utility.replaceWord(inputString, oldWord, newWord);
                    System.out.println("Updated string: " + inputString);
                    break;
                case 6:
                    System.out.print("Enter a new string: ");
                    inputString = scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

class StringUtility {

    public int countVowels(String str) {
        int count = 0;
        String lowerStr = str.toLowerCase();
        for (char ch : lowerStr.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public int countConsonants(String str) {
        int count = 0;
        String lowerStr = str.toLowerCase();
        for (char ch : lowerStr.toCharArray()) {
            if (Character.isLetter(ch) && "aeiou".indexOf(ch) == -1) {
                count++;
            }
        }
        return count;
    }

    public boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversed);
    }

    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public String replaceWord(String str, String oldWord, String newWord) {
        return str.replace(oldWord, newWord);
    }
}
