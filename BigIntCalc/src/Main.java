import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter equation:");
        InputResult result = parseInput(scanner.nextLine());
        StringBuilder res = new StringBuilder();
        System.out.println(add("333", "49"));
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
    public static int op(String num1, String num2, Operation op) {
        return(op(Integer.parseInt(num1), Integer.parseInt(num2), op));
    }
    public static int op(char num1, char num2, Operation op) {
        return(op(Integer.parseInt(String.valueOf(num1)), Integer.parseInt(String.valueOf(num2)), op));
    }
    public static String add(String char1, String char2) {
        String longest = char1;
        String shortest = char2;
        if (char2.length() > char1.length()) {
            longest = char2;
            shortest = char1;
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < longest.length(); i++) {
            if (shortest.length() <= longest.length() - i - 1) {
                System.out.println("Test");
                //I think problem here?
                res.append(Integer.parseInt(String.valueOf(longest.charAt(i))) + carry);
                continue;
            }
            String result = String.valueOf(op(longest.charAt(longest.length() - i - 1), shortest.charAt(longest.length() - i - 1), Operation.ADD) + carry);
            res.append(result.charAt(result.length() - 1));
            carry = 0;
            System.out.println("Result : " + result);
            if (result.length() > 1) carry = Integer.parseInt(result.substring(0, result.length() - 1));
            System.out.println("carry : " + carry);
        }
        if (carry > 0) res.append(carry);
        res.reverse();
        return res.toString();
    }
    public static String mult(String num1, String char2, int offset) {
        int num2 = Integer.parseInt(String.valueOf(char2));
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length(); i++) {
            int val = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int total = op(val, num2, Operation.MULTIPLY);
            total += carry;
            builder.append(String.valueOf(total).charAt(0));
            if (total < 10) {
                carry = 0;
                continue;
            }
            System.out.println(carry);
            carry = Integer.parseInt(String.valueOf(total).substring(0, String.valueOf(total).length() - 1));
        }
        builder.reverse();
        for (int i = 0; i < offset; i++) {
            builder.append("0");
        }
        return builder.toString();
    }
}