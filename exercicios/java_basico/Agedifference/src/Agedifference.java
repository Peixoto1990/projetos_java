public record Agedifference(int age1, int age2) {
    public int getDiff() {
        return Math.abs(age1 - age2);
    }
}