import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
  public double getNumber(Scanner scanner, String prompt) {
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

  public char getOperation(Scanner scanner) {
    char op;
    String choices = "+-*/%^";
    while (true) {
      System.out.print("Choose operation (+,-,*,/,%,^): ");
      op = scanner.next().charAt(0);
      if (choices.indexOf(op) != -1)
        break;
      System.out.println("Invalid operator, try again.");
    }
    return op;
  }

  public Double calculate(double x, char op, double y) {
    if (op == '/' && y == 0)
      return null;
    switch (op) {
      case '+':
        return x + y;
      case '-':
        return x - y;
      case '*':
        return x * y;
      case '/':
        return x / y;
      case '%':
        return x % y;
      case '^':
        return Math.pow(x, y);
      default:
        return null;
    }
  }

  public void printResult(double x, char op, double y, double res) {
    System.out.printf("%s %c %s = %s\n", formatter(x), op, formatter(y), formatter(res));
  }

  public String formatter(double x) {
    return x % 1 == 0 ? String.format("%.0f", x) : String.format("%.2f", x);
  }
}
