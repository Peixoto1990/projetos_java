public record Square(double side) {
    private double getArea() {
        return Math.pow(side, 2);
    }

    public String getMessage() {
        return "A área do quadrado que tem lado igual a " + side + " é de " + String.format("%.2f" ,getArea()) + ".";
    }
}