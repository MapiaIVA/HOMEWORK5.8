import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите идентификатор переменной: ");
        String input = scanner.nextLine();

        String result = convertVariable(input);
        System.out.println("Результат: " + result);
    }

    public static String convertVariable(String input) {
        if (isJavaVariable(input)) {
            return convertToCpp(input);
        } else if (isCppVariable(input)) {
            return convertToJava(input);
        } else {
            return "Невозможно определить язык переменной";
        }
    }

    public static boolean isJavaVariable(String input) {
        return input.matches("[a-z]+[A-Z][a-z]+");
    }

    public static boolean isCppVariable(String input) {
        return input.matches("[a-z_]+");
    }

    public static String convertToCpp(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append("_").append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String convertToJava(String input) {
        StringBuilder result = new StringBuilder();
        boolean toUpperCase = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '_') {
                toUpperCase = true;
            } else {
                if (toUpperCase) {
                    result.append(Character.toUpperCase(c));
                    toUpperCase = false;
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}