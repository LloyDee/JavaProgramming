package Section_2;

public class Com1 implements Calculator {

    @Override
    public double add(double num1, double num2) {
        System.out.print("The sum of " + num1 + " and " + num2 + " is: ");
        return Double.sum(num1, num2);
    }

    @Override
    public double min(double num1, double num2) {
        System.out.print("The difference of " + num1 + " and " + num2 + " is: ");
        return num1 - num2;
    }

    @Override
    public double div(double num1, double num2) {
        System.out.print("The quotient of " + num1 + " and " + num2 + " is: ");
        return num1 / num2;
    }

    @Override
    public double mul(double num1, double num2) {
        System.out.print("The product of " + num1 + " and " + num2 + " is: ");
        return num1 * num2;
    }

    @Override
    public String getInput() {
        return "Enter a number";
    }
}
