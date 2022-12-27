package Section_2;

import java.util.Scanner;

public class Test {
    public static Scanner scanner = new Scanner(System.in);
    static Com1 com1 = new Com1();
    public static void main(String[] args) {
        System.out.println(com1.getInput());
        double num1 = Double.parseDouble(scanner.next());
        System.out.println(com1.getInput());
        double num2 = Double.parseDouble(scanner.next());

        System.out.println("Select an operator\n1\tAddition\n2\tSubtraction\n3\tMultiplication\n4\tDivision");
        String operator = scanner.next();
        switch (operator) {
            case "1" -> System.out.println(com1.add(num1, num2));
            case "2" -> System.out.println(com1.min(num1, num2));
            case "3" -> System.out.println(com1.mul(num1, num2));
            case "4" -> System.out.println(com1.div(num1, num2));
        }

    }
}
