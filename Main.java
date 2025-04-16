import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    double firstNumber;
    double secondNumber;
    char operation;
    Double result;
    boolean repeat = true;

    Scanner userInput = new Scanner(System.in);
    Calculator calc = new Calculator();

    while (repeat) {
      firstNumber = calc.getNumber(userInput, "Enter first number: ");
      operation = calc.getOperation(userInput);
      secondNumber = calc.getNumber(userInput, "Enter second number: ");
      result = calc.calculate(firstNumber, operation, secondNumber);

      if (result == null) {
        System.out.println("Invalid operation or dividing by zero.");
      } else {
        calc.printResult(firstNumber, operation, secondNumber, result);
      }

      System.out.print("Calculate again? (Y/N): ");
      repeat = userInput.next().equalsIgnoreCase("Y");
    }
    userInput.close();
  }
}
