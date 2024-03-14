import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter equation:");
        InputResult result = parseInput(scanner.nextLine());
        for (int i = 0; i < result.num1.length(); i++) {

        }
    }

    public static InputResult parseInput(String str) {
        String[] strArray = str.split(" ");
        return new InputResult(strArray[0], strArray[2], operationFromStr(strArray[1]));
    }
    public static Operation operationFromStr(String str) {
        switch (str) {
            case ("+"): return Operation.ADD;
            case ("-"): return Operation.SUB;
            case ("*"): return Operation.MULTIPLY;
            case ("/"): return Operation.DIVIDE;
        }
        return null;
    }
    public static int op(int num1, int num2, Operation op) {
            if (op == Operation.ADD) return  num1 + num2;
            if (op == Operation.SUB) return  num1 - num2;
            if (op == Operation.MULTIPLY) return  num1 * num2;
            if (op == Operation.DIVIDE) return  num1 / num2;
            return -1;
    }
    public static String calculate(String num1, String char2, int offset, Operation op) {
        int mult = Integer.parseInt(String.valueOf(char2));
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length(); i++) {
            int val = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int total = op(val, mult, op);
            builder.append(String.valueOf(total).charAt(0));
            if (total < 10) {
                carry = 0;
                continue;
            }

        }
        builder.reverse();
        for (int i = 0; i < offset; i++) {
            builder.append("0");
        }
        return builder.toString();
    }
}