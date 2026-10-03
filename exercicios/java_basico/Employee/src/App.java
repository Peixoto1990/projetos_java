public class App {
    public static void main(String[] args) throws Exception {
        Employee seller = new Seller("Fabiano Silva", "fabiano@company.com", "123456");
        Employee attendant = new Attendant("Mariana Castro", "mariana@company.com", "654321");
        Employee manager = new Manager("Juliana Maria", "juliana@company.com", "12345678");

        Seller s = (Seller) seller;
        Attendant a = (Attendant) attendant;
        Manager m = (Manager) manager;

        s.login("fabiano@company.com", "123456");
        s.sell();
        s.getSales();

        a.login("mariana@company.com", "654321");
        a.openRegister();
        a.receivePayment(350);
        a.closeRegister();

        m.login("juliana@company.com", "12345678");
        m.checkSales(s);
        m.financialReport(a);
    }
}
