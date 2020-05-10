package foo.zongzhe.line.stack.app;

import java.util.Stack;

/**
 * 使用栈完成一个表达式的计算结果，暂时只支持一位整数的运算
 */
public class Calculator {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        String exp1 = "5+7*2*2+3-6*1";
        cal.calculate(exp1);

        String exp2 = "3+2*6-2";
        cal.calculate(exp2);

    }

    public void calculate(String exp) {
        String validExp = validate(exp);
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < validExp.length(); i++) {
            char ch = validExp.charAt(i);
            if (Character.isDigit(ch)) {
//                numbers.push((int) ch); // (int) ch 和Integer.valueOf(ch) 都会返回char对应的ASCII码
                numbers.push(Integer.valueOf(Character.toString(ch)));
            } else {
                /*
                 * 如果符号栈为空，则直接入栈；否则比较优先级
                 * 若优先级小或等于，则先计算里面已有的；否则直接入栈
                 */
                if (operators.isEmpty() || withHigherPriority(ch, operators)) {
                    operators.push(ch);
                } else {
                    int num2 = numbers.pop();
                    int num1 = numbers.pop();
                    char op = operators.pop();
                    int res = getResult(num1, num2, op);
                    numbers.push(res);
                    operators.push(ch);
                }
            }
        }

        // 扫描完毕后，就顺序的从数栈和符号栈中pop出相应数字和符号进行计算。
        while (!operators.isEmpty()) {
            int num2 = numbers.pop();
            int num1 = numbers.pop();
            char op = operators.pop();
            int res = getResult(num1, num2, op);
            numbers.push(res);
        }
        int finalRes = numbers.pop();
        System.out.println("result is: " + finalRes);
    }

    private int getResult(int num1, int num2, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = (int) num1 / num2;
                break;
        }
        return res;
    }

    private boolean withHigherPriority(char operator, Stack<Character> operators) {
        char peekOp = operators.peek();
        return !("+-".contains(Character.toString(operator)) || "*/".contains(Character.toString(peekOp)));
    }

    private String validate(String exp) {
        String validExp = exp;
        if (exp == null) {
            System.out.println("input is null, exiting");
            System.exit(0);
        }

        validExp = exp.replaceAll(" ", "");
        if (validExp.length() == 0) {
            System.out.println("input is empty, exiting");
            System.exit(0);
        }

        return validExp;
    }
}
