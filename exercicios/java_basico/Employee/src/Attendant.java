public final class Attendant extends Employee {
    private double daysPayment = 0;
    private double register = 0;
    private boolean isRegisterOpen = false;
    protected Attendant(String name, String email, String password) {
        super(name, email, password, false, "Atendente");
    }

    protected double getPayments() {
        return register;
    }

    protected void receivePayment(double value) {
        if (!isLoggedUser()) {
            System.out.println("Você precisa estar logado para receber pagamentos.");
            return;
        }

        if (!isRegisterOpen) {
            System.out.println("O caixa está fechado. Faça a abertura para receber pagamentos.");
            return;
        }

        if (value < 1) {
            System.out.println("Pagamento inválido.");
            return;
        }

        daysPayment += value;
        System.out.println("Pagamento recebido com sucesso.");
    }

    protected void closeRegister() {
        if (!isLoggedUser()) {
            System.out.println("Necessário estar logado para fechar o caixa.");
            return;
        }

        if (!isRegisterOpen) {
            System.out.println("O caixa já está fechado.");
            return;
        }

        isRegisterOpen = false;
        register += daysPayment;
        daysPayment = 0;
        System.out.println("Caixa fechado com sucesso.");
    }

    protected void openRegister() {
        if (!isLoggedUser()) {
            System.out.println("Você precisa estar logado para abrir o caixa.");
            return;
        }

        if (isRegisterOpen) {
            System.out.println("O caixa já está aberto.");
            return;
        }

        isRegisterOpen = true;
        System.out.println("Caixa aberto com sucesso.");
    }
} 