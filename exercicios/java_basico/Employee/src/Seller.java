public final class Seller extends Employee {
    private int sales = 0;

    protected Seller(String name, String email, String password) {
        super(name, email, password, false, "Vendedor");
    }

    protected void sell() {
        if (!isLoggedUser()) {
            System.out.println("Você precisa estar logado para poder vender produtos.");
            return;
        }

        ++sales;
        System.out.println("Venda realizada com sucesso.");
    }

    protected int getTotalSales() {
        return sales;
    }

    protected int getSales() {
        if (!isLoggedUser()) {
            System.out.println("Você precisa estar logado para consultar vendas.");
            return 0;
        }

        return sales;
    }

}