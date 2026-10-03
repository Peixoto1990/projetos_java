public final class Manager extends Employee {
    protected Manager(String name, String email, String password) {
        super(name, email, password, true, "Gerente");
    }

    protected void checkSales(Seller seller) {
        if (!isLoggedUser()) {
            System.out.println("É necessário estar logado para verificar vendas.");
            return;
        }

        System.out.println("||Verificação de vendas||");
        System.out.printf("Vendedor: %s\nVendas do dia: %s\n", seller.getName(), seller.getTotalSales());
    }

    protected void financialReport(Attendant attendant) {
        if (!isLoggedUser()) {
            System.out.println("Necessário estar logado para realizar esta ação.");
            return;
        }

        System.out.println("||Relatório Financeiro||");
        System.out.printf("Atendente: %s\nValor do caixa: R$ %s\n", attendant.getName(), String.format("%.2f", attendant.getPayments()));
    }

}