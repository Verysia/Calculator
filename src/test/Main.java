package test;

import java.util.Stack;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        new Calc();
        new Stack();

        while(true) {
            try {
                Read.ReadInput("");
                Calc.Calc(Read.getAction());
                if (Read.isNum(Read.getVar()[0]) && Read.isNum(Read.getVar()[1])) {
                    if (Integer.parseInt(Read.getVar()[0]) <= 10 && Integer.parseInt(Read.getVar()[1]) <= 10) {
                        System.out.print(Calc.getResult());
                    }
                } else if (!Read.isNum(Read.getVar()[0]) && !Read.isNum(Read.getVar()[1])) {
                    if (Read.RomanToInt(Read.getVar()[0]) <= 10 && Read.RomanToInt(Read.getVar()[1]) <= 10) {
                        System.out.print(Read.IntToRoman(Calc.getResult()));
                    }
                } else {
                    System.out.print("\n Неверный ввод");
                }
            } catch (Exception var4) {
                System.out.print("\n Неверный ввод");
            }

            Calc.setResult(0);
        }
    }
}



