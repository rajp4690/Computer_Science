/*
Raj Patel
N03555681
Programming and Data Structure
PostfixEvaluation
*/

import java.util.*;

public class PostfixEvaluation{

  public static void main(String[] arg){
    evaluate();
  }

  public static void evaluate(){

    System.out.println("Hello! This is a postfix expression calculator.");

    Scanner input = new Scanner(System.in);
    Stack<Double> numbers = new Stack<Double>();
    while(input.hasNextLine()){
      String expression = input.nextLine();
      Scanner inLine = new Scanner(expression);

      while(inLine.hasNext()){
        if (inLine.hasNextDouble()){
          numbers.push(inLine.nextDouble());
        }
        else{
          String next = inLine.next();
          char first = next.charAt(0);
          evaluateStackTop(first, numbers);
        }
      }
      System.out.println("\nThe value of \"" + expression + "\" is " + numbers.pop());
    }
    System.out.println("\nBye-bye!");
  }

  public static void evaluateStackTop(char first, Stack<Double> numbers){

    double operand1 = 0, operand2;
    operand2 = numbers.pop();
    if(first != '_' && first != '#')
      operand1 = numbers.pop();
    switch(first){
      case '+' :
        numbers.push(operand1 + operand2);
        break;
      case '-' :
        numbers.push(operand1 - operand2);
        break;
      case '*' :
        numbers.push(operand1 * operand2);
        break;
      case '/' :
        numbers.push(operand1 / operand2);
        break;
      case '_' :
        numbers.push(-operand2);
        break;
      case '#' :
        numbers.push(Math.sqrt(operand2));
        break;
      case '^' :
        numbers.push(Math.pow(operand1,operand2));
        break;
    }
  }
}
