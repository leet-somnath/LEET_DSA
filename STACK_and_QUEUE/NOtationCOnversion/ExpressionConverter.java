import java.util.Stack;

public class ExpressionConverter {

    // Function to check if character is an operator
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Function to get precedence of operators
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Infix to Postfix conversion
    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Infix to Prefix conversion
    public static String infixToPrefix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                operands.push(c + "");
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    String op2 = operands.pop();
                    String op1 = operands.pop();
                    char op = operators.pop();
                    String temp = op + op1 + op2;
                    operands.push(temp);
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    String op2 = operands.pop();
                    String op1 = operands.pop();
                    char op = operators.pop();
                    String temp = op + op1 + op2;
                    operands.push(temp);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            String op2 = operands.pop();
            String op1 = operands.pop();
            char op = operators.pop();
            String temp = op + op1 + op2;
            operands.push(temp);
        }

        return operands.pop();
    }

    // Prefix to Infix conversion
    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } else if (isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    // Postfix to Infix conversion
    public static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } else if (isOperator(c)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String infix = "A+B*C";
        System.out.println("Infix to Postfix: " + infixToPostfix(infix));
        System.out.println("Infix to Prefix: " + infixToPrefix(infix));
        
        String prefix = "+A*BC";
        System.out.println("Prefix to Infix: " + prefixToInfix(prefix));
        
        String postfix = "ABC*+";
        System.out.println("Postfix to Infix: " + postfixToInfix(postfix));
    }
}

/*
### Steps for Conversion

#### Infix to Postfix Conversion:
1. **Character**: Append to the result.
2. **Operator**: Pop operators from the stack with higher or equal precedence; push current operator to stack.
3. **Parentheses**:
   - **'('**: Push to stack.
   - **')'**: Pop until '(' is found (discard '(').

#### Infix to Prefix Conversion:
1. **Character**: Push to operand stack.
2. **Operator**: Pop operators of higher/equal precedence; push current operator to operator stack.
3. **Parentheses**:
   - **'('**: Push to operator stack.
   - **')'**: Pop until '(' is found (discard '(').
4. **Result**: Pop all operators, combining with operands in the prefix format.

#### Prefix to Infix Conversion:
1. **Character**: Push to stack.
2. **Operator**: Pop two operands; combine as `(op1 operator op2)`, then push result back to stack.

#### Postfix to Infix Conversion:
1. **Character**: Push to stack.
2. **Operator**: Pop two operands; combine as `(op1 operator op2)`, then push result back to stack.
*/ 
 {
    
}
