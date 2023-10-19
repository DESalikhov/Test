import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number1, number2;
        char operation = 0;
        int result;
        System.out.println("Введите выражение");
        String str = scanner.nextLine();
        char[] mass = new char[10];
        for (int i = 0; i < str.length(); i++) {
            mass[i] = str.charAt(i);
            if (mass[i] == '+') {
                operation = '+';
            }
            if (mass[i] == '-') {
                operation = '-';
            }
            if (mass[i] == '*') {
                operation = '*';
            }
            if (mass[i] == '/') {
                operation = '/';
            }
        }

        String massString = String.valueOf(mass);
        String[] string = massString.split("[+-/*]");
        String str1 = string[0];
        String str2 = string[1];
        String str3 = str2.trim();

        if (NumRoman.romanToNumber(str1) != -1) {
            number1 = NumRoman.romanToNumber(str1);
            number2 = NumRoman.romanToNumber(str3);
            result = calculated(number1, number2, operation);
            String resultRoman = NumRoman.convertNumToRoman(result);
            System.out.println(resultRoman);
        } else {
            number1 = Integer.parseInt(str1);
            number2 = Integer.parseInt(str3);
            result = calculated(number1, number2, operation);
            System.out.println(result);
        }
    }

    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак");
        }
        return result;
    }
}

