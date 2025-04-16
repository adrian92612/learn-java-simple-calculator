import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    double firstNumber;
    double secondNumber;
    char operation;
    Double result;
    boolean repeat = true;

    Scanner userInput = new Scanner(System.in);

    while (repeat) {
      firstNumber = getNumber(userInput, "Enter first number: ");
      operation = getOperation(userInput);
      secondNumber = getNumber(userInput, "Enter second number: ");
      result = calculate(firstNumber, operation, secondNumber);

      if (result == null) {
        System.out.println("Invalid operation or dividing by zero.");
      } else {
       printResult(firstNumber, operation, secondNumber, result);
      }

      System.out.print("Calculate again? (Y/N): ");
      repeat = userInput.next().equalsIgnoreCase("Y");
    }
  }

  static double getNumber(Scanner scanner, String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return scanner.nextDouble();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input.");
        scanner.next();
      }
    }
  }

  static char getOperation(Scanner scanner) {
    char op;
    while (true) {
      System.out.print("Choose operation (+,-,*,/): ");
      op = scanner.next().charAt(0);
      if ("+-*/".indexOf(op) != -1) break;
      System.out.println("Invalid operation, try again.");
    }
    return op;
  }

  static Double calculate(double num1,char operation,double num2) {
    if (operation == '/' && num2 == 0) return null;
    
    switch (operation) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        return num1 / num2;
      default:
        return null;
    }
  }

  static void printResult(double x, char op, double y, double res) {
    System.out.println(String.format("%s %c %s = %s", formatter(x),op,formatter(y),formatter(res)));
  }

  static String formatter(double num) {
    return num % 1 == 0 ? String.format("%.0f", num) : String.format("%.2f",num);
  }
}
