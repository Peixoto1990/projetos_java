public record Rectangle(double base, double height) {
    private double getArea() {
        return base * height;
    }

    public String getMessage() {
        return "A área do retângulo de base " + base + " e altura " + height + " é de " + String.format("%.2f", getArea()) + ".";
    }
}