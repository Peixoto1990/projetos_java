import java.time.OffsetDateTime;
import java.util.Scanner;

public class Account {
    private static int totalAccounts = 0;
    private int accountNumber;
    private double accountBalance;
    private double deposit;
    private double overdraft;
    private double availableOverdraft;
    private double overdraftDebt;
    private float overdraftRate = 0.2f;
    private boolean isUsingOverdraft = false;
    private Person client;

    public Account(String cName, String cCpf, int cBirth, double deposit) {
        client = new Person(cName, cCpf, cBirth);
        this.deposit = deposit < 0 ? 0 : deposit;
        this.createAccount();
    }

    private void createAccount() {
        if (OffsetDateTime.now().getYear() - client.birth() < 18) {
            System.out.println("Você deve ser maior de 18 anos para abrir uma conta.\nOperação cancelada.");
            return; 
        }
        if (!client.cpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            System.out.println("Cpf inválido.\n Operação cancelada.");
            return; 
        }

        totalAccounts++;
        this.accountNumber = totalAccounts;
        this.accountBalance = this.deposit;
        this.overdraft = this.accountBalance <= 500 ? 50 : (this.deposit * 50 / 100);
        this.availableOverdraft = this.overdraft;
        this.deposit = 0;
        this.welcomeMessage();
    }

    private void welcomeMessage() {
        System.out.printf("Olá %s, você foi aprovado e sua conta de número %s foi criada.\nParabéns!\n", client.name(), this.accountNumber);
    }

    public double getAccountBalance() {
        System.out.printf("Saldo: R$ %s\nCheque especial: R$ %s\n", String.format("%.2f", this.accountBalance), String.format("%.2f", this.availableOverdraft));
        return this.accountBalance;
    }

    public void getOverdraft(Scanner scanner) {
        System.out.println("Consulta de cheque especial");
        System.out.printf("Valor disponível: R$ %s\n", String.format("%.2f", this.availableOverdraft));
        if (this.isUsingOverdraft) {
            System.out.println("Você já está utilizando cheque especial.\nFaça a quitação para poder voltar a utilizar.");
            return; 
        }
        String opt = "";
        while (!opt.equalsIgnoreCase("n") && !opt.equalsIgnoreCase("s")) {
            System.out.println("Deseja utilizar? [N / S]");
            opt = scanner.nextLine();
            if (!opt.equalsIgnoreCase("n") && !opt.equalsIgnoreCase("s")) {
                System.out.println("Opção inválida.");
            }
        }
        if (opt.equalsIgnoreCase("n")) {
            System.out.println("Consulta finalizada.");
            return; 
        }
        int vOpt = -1;
        String[] values = {String.format("%.2f", this.availableOverdraft / 3), String.format("%.2f", this.availableOverdraft / 3 * 2), String.format("%.2f", this.availableOverdraft)};
        do {
            System.out.println("Escolha o valor:");
            System.out.printf("[1 - 1/3 (R$ %s)]\n[2 - 2/3 (R$ %s)]\n[3 - 3/3 (integral)]\n[0 - cancelar]\n", values[0], values[1], values[2]);
            vOpt = Integer.parseInt(scanner.nextLine());
            if (vOpt != 1 && vOpt != 2 && vOpt != 3 && vOpt != 0) {
                System.out.println("Opção inválida.");
            }
        } while (vOpt != 1 && vOpt != 2 && vOpt != 3 && vOpt != 0);
        double selectedValue;
        if (vOpt > 0) {
            selectedValue = (this.availableOverdraft / 3 * vOpt);
            this.overdraftDebt = selectedValue + (selectedValue * this.overdraftRate);
            this.accountBalance += selectedValue;
            this.availableOverdraft -= selectedValue;
            this.isUsingOverdraft = true;
            System.out.println("Cheque especial incorporado ao seu saldo.");
            System.out.printf("Saldo: R$ %s\n", String.format("%.2f", this.accountBalance));
            return; 
        }
        System.out.println("Operação cancelada pelo usuário.");
    }

    public void setDeposit(double value) {
        if (value <= 0) {
            System.out.println("Valor inválido. Tente novamente.");
            return; 
        }
        if (this.isUsingOverdraft && this.overdraftDebt <= value) {
            double realValue = value - this.overdraftDebt;
            System.out.printf("Operação concluída.\nValor depositado: R$ %s\nDívida de cheque especial quitada: R$ %s\n", String.format("%.2f", realValue), String.format("%.2f", this.overdraftDebt));
            this.overdraftDebt = 0;
            this.availableOverdraft = this.overdraft;
            this.isUsingOverdraft = false;
            this.accountBalance += realValue;
            System.out.printf("Saldo: R$ %s\n", String.format("%.2f", this.accountBalance));
            System.out.println("Cheque especial disponível para uso novamente.");
            return;
        }
        this.accountBalance += value;
        System.out.printf("Depósito realizado com sucesso.\nSaldo: R$ %s\n", String.format("%.2f", this.accountBalance));
    }

    public void withDraw(double value) {
        if (value <= 0) {
            System.out.println("Valor inválido. Tente novamente");
            return; 
        }

        if (this.accountBalance <= 0 || value > this.accountBalance) {
            System.out.println("Sem saldo na conta, favor faça um depósito ou use o cheque especial.");
            return; 
        }
        this.accountBalance -= value;
        System.out.printf("Você sacou R$ %s\nSaldo: R$ %s\n", String.format("%.2f", value), String.format("%.2f", this.accountBalance));
    }

    public void pay(double value) {
        if (value <= 0) {
            System.out.println("Valor inválido. Tente novamente");
            return;
        }

        if (this.accountBalance <= 0 || value > this.accountBalance) {
            System.out.println("Sem saldo na conta, favor faça um depósito ou use o cheque especial.");
            return; 
        }
        this.accountBalance -= value;
        System.out.printf("Você efetuou um pagamento de R$ %s\nSaldo: R$ %s\n", String.format("%.2f", value), String.format("%.2f", this.accountBalance));
    }

    public void usingOverdraft() {
        System.out.println(isUsingOverdraft ? "Cheque especial em uso." : "Cheque especial não usado.");
    }
}
