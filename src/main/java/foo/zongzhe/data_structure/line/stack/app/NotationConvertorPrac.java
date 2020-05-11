package foo.zongzhe.data_structure.line.stack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 * 中缀示例：(((35+15)*(80-70))/20
 * 后缀示例：35,15,+,80,70,-,*,20,/
 * 说明：
 * 1. 因为直接对str操作不太方便，所以现将str转换成中缀表达式对应的List
 * 2. 将得到的中缀List转成后缀表达式对应的List
 * TODO: 解决bug
 */
public class NotationConvertorPrac {
//    private static Stack<Character> stk1;
//    private static Stack<Character> stk2;

    public static void main(String[] args) {
        String input1 = "1+ ( ( 2 + 3 ) * 4 ) - 5"; // 此处input的元素之间用空格分开，因为我偷懒不想做多位数识别
        List<String> inFixExp = toInfixExpressionList(input1);
        System.out.println(inFixExp);

        List<String> sufdfixExp = parseSuffixExpressionList(inFixExp);
        System.out.println(sufdfixExp);
    }

    /**
     * 将中缀表达式转换成个对应的List
     *
     * @param input
     * @return
     */
    public static List<String> toInfixExpressionList(String input) {
        input = input.replaceAll(" ", "");
        // 定义一个list，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str = ""; // 对多位数进行拼接
        char c;
        do {
            // 如果c是一个非数字，就需要加入到ls里面去
            c = input.charAt(i);
            if (!Character.isDigit(c)) {
                ls.add(Character.toString(c));
                i++;
            } else {
                // 如果是一个数，则需要考虑多位数的问题
                str = "";
                do {
                    str += input.charAt(i);
                    i++;
                } while (i < input.length() && Character.isDigit(input.charAt(i)));
                ls.add(str);
            }
        } while (i < input.length());
        return ls;
    }

    /**
     * 转换后缀
     *
     * @param list 中缀表达式对应的List
     */
    private static List<String> parseSuffixExpressionList(List<String> list) {
        // Stk1 储存运算符， stk2储存中间结果
        Stack<String> stk1 = new Stack<>();
        List<String> stk2 = new ArrayList<>(); // 因为s2这个栈在转换过程中从不pop，且最后需要逆序输出，所以List其实更方便

        // 遍历ls
        for (String s : list) {
            // 遇到数字时，直接将其压入s2
            if (s.matches("\\d+")) {
                stk2.add(s);
            } else if (s.equals("(")) {
                stk1.push(s);
            } else if (s.equals(")")) {
                // 如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止，此时将这一对括号丢弃
                while (!stk1.peek().equals("(")) {
                    stk2.add(stk1.pop());
                }
                stk1.pop(); // 消除左括号
            } else {
                // 当传进来的运算符的优先级小于等于s1栈顶的运算符优先级时，将s1栈顶的运算符弹出并加入s2中，再次转到s1中与新的栈顶运算符比较
                while (stk1.size() > 0 && isWithLowerPriority(s, stk1.peek())) {
                    stk2.add(stk1.pop());
                }
                // 将s压栈
                stk1.push(s);
            }
        }

        // 将s1中的运算符一次弹出并加入s2
        while (stk1.size() > 0) {
            stk2.add(stk1.pop());
        }
        return stk2;
    }

    private static boolean isWithLowerPriority(String inputOp, String topOp) {
        return "+-".contains(inputOp) || "*/".contains(topOp);
    }
}
