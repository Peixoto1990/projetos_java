public sealed abstract class Employee permits Manager, Seller, Attendant {
    private String name;
    private String email;
    private String password;
    private final boolean IS_ADMIN;
    private boolean logged = false;
    private final String EMPLOYEE_TYPE;
    
    protected Employee(String name, String email, String password, final boolean IS_ADMIN, final String EMPLOYEE_TYPE) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.IS_ADMIN = IS_ADMIN;
        this.EMPLOYEE_TYPE = EMPLOYEE_TYPE;
    }

    protected boolean isAdmin() {
        return IS_ADMIN;
    }
    
    protected void setPassword(String newPassword) {
        if (!isLoggedUser()) {
            System.out.println("Necessário estar logado para mudar a senha.");
            return;
        }

        if (newPassword.length() < 6) {
            System.out.println("Necessário ao menos 6 caracteres para definir senha.");
            return;
        }

        this.password = newPassword;
        System.out.println("Senha alterada com sucesso.");
    }

    protected boolean isLoggedUser() {
        return logged;
    }

    protected void login(String email, String password) {
        if (isLoggedUser()) {
            System.out.println("Você já está logado.");
            return;
        }

        if (!getEmail().equals(email)) {
            System.out.println("Email não existe na base de dados.");
            return;
        }

        if (!isCorrectPassword(password)) {
            System.out.println("A senha digitada está incorreta.");
            return;
        }

        this.logged = true;
        System.out.println("Login efetuado com sucesso.");
        System.out.printf("Sessão Iniciada: %s\n", EMPLOYEE_TYPE);
    }

    protected void logoff() {
        if (!isLoggedUser()) {
            System.out.println("Você já está desconectado.");
            return;
        }

        this.logged = false;
        System.out.println("Logoff efetuado com sucesso.");
    }

    protected void setUserData(String newName, String newEmail) {
        if (!isLoggedUser()) {
            System.out.println("Necessário estar logado para alterar seus dados.");
            return;
        }

        if (newName.length() < 9) {
            System.out.println("Novo nome precisa ter ao menos 9 caracteres.");
            return;
        }

        if (!newEmail.matches(".{3,}@company\\.com")) {
            System.out.println("Novo e-mail deve seguir o seguinte padrão:");
            System.out.println("xxx@company.com");
            return;
        }

        this.name = newName;
        this.email = newEmail;
        System.out.println("Dados alterados com sucesso.");
    }

    protected String getName() {
        return this.name;
    }

    protected boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }
    
    protected String getEmail() {
        return this.email;
    }

}