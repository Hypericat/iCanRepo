import javax.print.DocFlavor;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter equation:");
        InputResult result = parseInput(scanner.nextLine());
        StringBuilder res = new StringBuilder();

    }
    public static void sub(String char1, String char2) {

    }
    public static void testEquations() {
        for (int i = 0; i < 100000; i++) {
            int num1 = (int) (Math.random() * 1000000);
            int num2 = (int) (Math.random() * 1000000);
            String resulty = add(String.valueOf(num1), String.valueOf(num2));
            if (!resulty.equals(String.valueOf(num1 + num2))) {
                System.err.println("Error numbers did not work: " + num1 + " + " + num2 + " = " + resulty);
            }
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
    public static int op(String num1, String num2, Operation op) {
        return(op(Integer.parseInt(num1), Integer.parseInt(num2), op));
    }
    public static int op(char num1, char num2, Operation op) {
        return(op(Integer.parseInt(String.valueOf(num1)), Integer.parseInt(String.valueOf(num2)), op));
    }
    public static String add(String char1, String char2) {
        boolean is1neg = char1.startsWith("-");
        boolean is2neg = char2.startsWith("-");
        char1.replace("-", "");
        char2.replace("-", "");
        String longest = char1;
        StringBuilder shortest = new StringBuilder(char2);
        if (char2.length() > char1.length()) {
            longest = char2;
            shortest = new StringBuilder(char1);
        }
        StringBuilder res = new StringBuilder();
        while (longest.length() > shortest.length()) {
            shortest.insert(0, "0");
        }
        int carry = 0;
        for (int i = 0; i < longest.length(); i++) {
            if (shortest.length() <= longest.length() - i - 1) {
                String huh = String.valueOf(Integer.parseInt(String.valueOf(longest.charAt(i))) + carry);
                res.append(huh.charAt(huh.length() - 1));
                if (huh.length() > 1) {
                    carry = Integer.parseInt(huh.substring(0, huh.length() - 1));
                }
                continue;
            }
            String result = String.valueOf(op(longest.charAt(longest.length() - i - 1), shortest.charAt(longest.length() - i - 1), Operation.ADD) + carry);
            res.append(result.charAt(result.length() - 1));
            carry = 0;
            if (result.length() > 1) carry = Integer.parseInt(result.substring(0, result.length() - 1));
        }
        if (carry > 0) res.append(carry);
        res.reverse();
        return res.toString();
    }
}