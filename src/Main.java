import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Input:");
        Scanner str1 = new Scanner((System.in));
        String input = str1.nextLine();
        System.out.println();
        System.out.println("Output: ");
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {

        int a;
        int b;
        boolean Rimskie;
        String result;
        String c;

        String[] symbols = input.split(" ");
        if (symbols.length != 3) throw new Exception("Введите два числа в формате:a + b, два операнда и один оператор, через пробел");
        c = symbols[1];

        //проверка являются ли оба числа римскими
        if (Rim.Rimskie(symbols[0]) && Rim.Rimskie(symbols[2])) {
            a = Rim.convAr(symbols[0]);//конвертируем римские числа в арабские
            b = Rim.convAr(symbols[2]);//конвертируем римские числа в арабские
            Rimskie = true;
        }
        //проверка  являются ли оба числа арабские
        else if (!Rim.Rimskie(symbols[0]) && !Rim.Rimskie(symbols[2])) { //отрицание римского числа при проверке, т.е. арабское
            a = Integer.parseInt(symbols[0]);
            b = Integer.parseInt(symbols[2]);
            Rimskie = false;
        }
        //если одно число римское, а второе арабское
        else {
            throw new Exception("Введите числа одной системы счисления");
        }
        if (a > 0 && a <= 10 && b > 0 && b <= 10) {
        } else throw new Exception("Введите целые числа от 1 до 10");

        int ar = calculator(a, b, c); // в методе делаем вычисление
        if (Rimskie) { // в переменной  получаем результат
            //если римское число получилось меньше либо равно нуля, генерируем ошибку
            if (ar <= 0) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            //конвертируем результат операции из арабского в римское
            result = Rim.convRim(ar);
        } else {
            //Конвертируем арабское число в тип String
            result = String.valueOf(ar);
        }
        //возвращаем результат
        return result;
    }
    static int calculator (int a, int b, String c) {
        switch(c) {
            case "+" -> {return a+b;}
            case "-" -> {return (a-b);}
            case "*" -> {return a*b;}
            case "/" -> {return  a/b;}
            default -> throw new IllegalStateException("Введите оператор в формате (+, -, *, /)");
        }
    }
}
class Rim { //массив римских цифр от I(1) до C(100)
    static String[] rimskie = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
            "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI","XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
            "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
            "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI",
            "LXVII", "LXVIII", "LXIX", "LXX", "LXXI","LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
            "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
            "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    static boolean Rimskie(String val) { //метод поиска римского числа в массиве
        for (int i = 0; i < rimskie.length; i++) {
            if (val.equals(rimskie[i])) {
                return true;
            }
        }
        return false;
    }
    static int convAr(String roman) { //метод конвертации арабского в римское число
        for (int i = 0; i < rimskie.length; i++) {
            if (roman.equals(rimskie[i])) {
                return i;
            }
        }
        return  -1;
    }
    static String convRim(int ar) { //метод конвертации римского в арабское
        return rimskie[ar]; }
}




