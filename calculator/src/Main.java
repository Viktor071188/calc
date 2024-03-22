import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример: ");
        String primer = in.nextLine();
        String newPrimer = primer.replaceAll(" ", ""); //удаляем лишние пробелы
        String[] parts = newPrimer.split("[+-/*]");
        if (parts.length != 2) throw new Exception("Должно быть два целых числа");
        String oper = detectOperation(newPrimer);
        if (oper == null)
            throw new Exception("Неподдерживаемая математическая операция");// разделяем строку на подстроки
        String part1 = parts[0];
        String part2 = parts[1];
        int num1 = Integer.parseInt(part1);//переводим строку в число
        int num2 = Integer.parseInt(part2);
        if (num1 > 10 || num2 > 10)
            throw new Exception("неподходящее число");
        //System.out.println(num1 + num2);
        char[] chars = newPrimer.toCharArray(); //разбиваем строку на символы.
        for (char c : chars) {
            if (c == '+') {
                System.out.println(num1 + num2);
            } else if (c == '-') {
                System.out.println(num1 - num2);
            } else if (c == '*') {
                System.out.println(num1 * num2);
            } else if (c == '/') {
                System.out.println(num1 / num2);
            }
        }
        // char[] chars = newPrimer.toCharArray();
        //for (char c: chars) {
        //    System.out.println(c);
    }

    //System.out.println(primer);
    static String detectOperation(String expression) {
        String a;
        if (expression.contains("+"))
            a = "+";
        else if (expression.contains("-"))
            a = "-";
        else if (expression.contains("*"))
            a = "*";
        else if (expression.contains("/"))
            a = "/";
        else return null;
        return a;
    }
}