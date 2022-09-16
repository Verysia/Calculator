package test;

public class Calc {
    private static int result = 0;

    public Calc() {
    }

    public static int getResult() {
        return result;
    }

    public static void setResult(int result) {
        Calc.result = result;
    }

    public static int Calc(char ch) {
        switch (ch) {
            case '+':
                result = Read.getTmp()[1] + Read.getTmp()[0];
                return result;
            case ',':
            case '.':
            default:
                return 0;
            case '-':
                result = Read.getTmp()[1] - Read.getTmp()[0];
                return result;
            case '/':
                if (Read.getTmp()[0] != 0) {
                    result = Read.getTmp()[1] / Read.getTmp()[0];
                    return result;
                } else {
                    System.out.println("На ноль делить нельзя");
                }
            case '*':
                if (Read.getTmp()[0] != 0 && Read.getTmp()[1] != 0) {
                    result = Read.getTmp()[1] * Read.getTmp()[0];
                    return result;
                } else {
                    result = 0;
                    return result;
                }
        }
    }
}





