public class Main {
    private static final String[] COLORS = {
            "preto", "marrom", "vermelho", "laranja", "amarelo",
            "verde", "azul", "violeta", "cinza", "branco"
    };

    public static String converterStringParaCor(String input) {
        String valueStr = input.split(" ")[0];
        double value = Double.parseDouble(valueStr.replaceAll("[kM]", ""));


        if (valueStr.endsWith("k")) {
            value *= 1000;
        } else if (valueStr.endsWith("M")) {
            value *= 1000000;
        }

        int ohms = (int) Math.round(value);

        String ohmsStr = String.valueOf(ohms);
        int firstDigit = Character.getNumericValue(ohmsStr.charAt(0));
        int secondDigit = Character.getNumericValue(ohmsStr.charAt(1));


        int multiplier = ohmsStr.length()-2;

        return COLORS[firstDigit] + " " + COLORS[secondDigit] + " " + COLORS[multiplier] + " dourado";
    }

    public static void main(String[] args) {
        String[] testCases = {
                "47 ohms", "4.7k ohms", "1M ohms", "10 ohms", "100 ohms",
                "220 ohms", "330 ohms", "470 ohms", "680 ohms", "1k ohms", "2M ohms"
        };

        for (String testCase : testCases) {
            System.out.println(testCase + " : " + converterStringParaCor(testCase));
        }
    }
}