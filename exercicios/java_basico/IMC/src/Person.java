public record Person(String name, double height, double weight) {
    public double getIMC() {
        return (weight / (height * height));
    }

    public String getIMCMessage() {
        double IMC = getIMC();
        String initialMessage = "Olá, %s, sua faixa IMC é %s. \nResultado: ";
        String rangeMessage = "";
        if (IMC <= 18.5 ) {
            rangeMessage = "Abaixo do peso.";
        } else if (IMC > 18.5 && IMC <= 24.9) {
            rangeMessage = "Peso ideal.";
        } else if (IMC > 24.9 && IMC <= 29.9) {
            rangeMessage = "Levemente acima do peso.";
        } else if (IMC > 29.9 && IMC <= 34.9) {
            rangeMessage = "Obesidade Grau I.";
        } else if (IMC > 34.9 && IMC <= 39.9) {
            rangeMessage = "Obesidade Grau II (Severa).";
        } else {
            rangeMessage = "Obesidade Grau III (Mórbida).";
        }
        return initialMessage + rangeMessage + "\n";
    }
}