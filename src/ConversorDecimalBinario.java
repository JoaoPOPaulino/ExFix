public class ConversorDecimalBinario {
    public static String decimalParaBinario(int num) {
        if (num == 0) {
            return "0";
        }
        return auxiliarDecimalParaBinario(num);
    }

    private static String auxiliarDecimalParaBinario(int num) {
        if (num <= 1) {
            return Integer.toString(num);
        }
        return auxiliarDecimalParaBinario(num / 2) + (num % 2);
    }

    public static void main(String[] args) {
        int numero = 43;
        System.out.println(decimalParaBinario(numero));
    }
}
