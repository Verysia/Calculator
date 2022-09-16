package test;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Integer;

public class Read {
    private static int[] tmp = new int[2];
    private static char action = 0;
    private static String[] var = new String[2];

    public Read() {
    }

    public static int[] getTmp() {
        return tmp;
    }

    public static char getAction() {
        return action;
    }

    public static String[] getVar() {
        return var;
    }

    public static boolean isNum(String string) {
        try {
            Integer.parseInt(String.valueOf(string));
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }

    public static void ReadInput(String string) {
        Stack<Integer> stack = new Stack();
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Введите выражение: ");
        if (string.length() == 0) {
            string = sc.nextLine();
        }

        var = string.split("[+/*-]");

        try {
            action = string.charAt(var[0].length());
            if (var.length > 1) {
                int i;
                for(i = 0; i < var.length; ++i) {
                    if (isNum(var[i])) {
                        if (Integer.parseInt(var[i]) > 10) {
                            System.out.print("\n Операнды не могут быть больше 10");
                            break;
                        }

                        stack.push(Integer.parseInt(var[i]));
                    } else if (RomanToInt(var[i]) != 0) {
                        if (RomanToInt(var[i]) > 10) {
                            System.out.print("\n Операнды не могут быть больше 10");
                            break;
                        }

                        stack.push(RomanToInt(var[i]));
                    }
                }

                for(i = 0; i < var.length; ++i) {
                    tmp[i] = (Integer)stack.pop();
                }
            } else {
                System.out.print("\n Неверный ввод");
            }
        } catch (Exception var4) {
            System.out.println("\n Неверный ввод");
        }

    }

    public static int RomanToInt(String string) {
        String[] roman = new String[]{"C", "XC", "L", "XL", "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        int[] arab = new int[]{100, 90, 50, 40, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        StringBuffer romeNum = new StringBuffer(string);
        int i = 0;
        int arabNum = 0;
        if (romeNum.length() <= 0) {
            return 0;
        } else {
            while(true) {
                if (roman[i].length() <= romeNum.length()) {
                    if (roman[i].equals(romeNum.substring(0, roman[i].length()))) {
                        arabNum += arab[i];
                        romeNum.delete(0, roman[i].length());
                    }

                    if (romeNum.length() == 0) {
                        return arabNum;
                    }
                }

                ++i;
            }
        }
    }

    public static String IntToRoman(Integer in) {
        StringBuffer sb = new StringBuffer("");

        int c1 = in / 100;
        sb.append(C(c1));
        int c2 = in % 100;
        int l1 = c2 / 50;
        sb.append(L(l1));
        int l2 = c2 % 50;
        int x1 = l2 / 10;
        sb.append(X(x1));
        int x2 = l2 % 10;
        sb.append(Naturals(x2));
        return sb.toString();
    }

    private static String C(int in) {
        if (in == 4) {
            return "CD";
        } else if (in != 0 && in < 4) {
            StringBuffer sb = new StringBuffer("");

            for(int i = 0; i < in; ++i) {
                sb.append("C");
            }

            return sb.toString();
        } else {
            return "";
        }
    }

    private static String L(int in) {
        if (in == 4) {
            return "XL";
        } else {
            return in != 0 && in < 4 ? "L" : "";
        }
    }

    private static String X(int in) {
        if (in == 4) {
            return "XL";
        } else if (in != 0 && in < 4) {
            StringBuffer sb = new StringBuffer("");

            for(int i = 0; i < in; ++i) {
                sb.append("X");
            }

            return sb.toString();
        } else {
            return "";
        }
    }

    private static String Naturals(int in) {
        String[] str = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VII", "IX", "X"};
        return str[in];
    }

    public static void main(String[] args) {
    }
}




