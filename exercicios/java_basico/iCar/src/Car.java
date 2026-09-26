import java.util.Scanner;

public class Car {
    private boolean power = false;
    private int gear = 0; //0 N, 1, 2, 3, 4, 5, 6 [velocidades]
    private int velocity = 0;
    private final int maxVelocity = 120;
    private final int minVelocity = 0;
    private Driver driver = null;
    private boolean isDriverIntoCar = false;

    public void setDriver(Scanner scanner) {
        if (driver != null) {
            System.out.println("Já tem um motorista dirigindo o carro.\nAguarde ele voltar.");
            return;
        }
        String name;
        String cpf;
        int birth;
        System.out.println("Informe seu nome:");
        name = scanner.nextLine();
        System.out.println("Informe seu cpf:");
        cpf = scanner.nextLine();
        System.out.println("Informe seu ano de nascimento:");
        birth = Integer.parseInt(scanner.nextLine());
        driver = new Driver(name, cpf, birth);
        if (driver.getLicence() != null) {
            System.out.printf("Parabéns %s.\nAgora você pode ligar o carro.\n", driver.getName());
            this.isDriverIntoCar = true;
            return;
        }
        System.out.println("É necessário um motorista habilitado para dirigir o carro.");
        driver = null;
        this.isDriverIntoCar = false;
    }

    public void startCar() {
        if (!this.isDriverIntoCar) {
            System.out.println("É necessário um motorista habilitado para ligar o carro.");
            return;
        }

        if (this.power) {
            System.out.println("O carro já está ligado. Engate a 1ª marcha para acelerar");
            return;
        }

        this.power = true;
        System.out.println("Ligando carro... vruuuuummmmmmm...");
        System.out.println("Carro ligado, câmbio no Neutro. Engate a 1ª marcha para acelerar.");
    }

    public void changeUpGear() {
        if (!this.power) {
            System.out.println("Você precisar ligar o carro para poder engatar uma marcha.");
            return;
        }

        if (this.velocity == this.minVelocity) {
            if (this.gear == 0) {
                this.gear = 1;
                System.out.printf("%sª marcha engatada.\n", this.gear);
                return;
            }
        }

        if (this.velocity == 20) {
            if (this.gear == 1) {
                this.gear = 2;
                System.out.printf("%sª marcha engatada.\n", this.gear);
                return;
            }
        }

        if (this.velocity == 40) {
            if (this.gear == 2) {
                this.gear = 3;
                System.out.printf("%sª marcha engatada.\n", this.gear);
                return;
            }
        }

        if (this.velocity == 60) {
            if (this.gear == 3) {
                this.gear = 4;
                System.out.printf("%sª marcha engatada.\n", this.gear);
                return;
            }
        }

        if (this.velocity == 80) {
            if (this.gear == 4) {
                this.gear = 5;
                System.out.printf("%sª marcha engatada.\n", this.gear);
                return;
            }
        }

        if (this.velocity == 100) {
            if (this.gear == 5) {
                this.gear = 6;
                System.out.printf("%sª marcha engatada.\n", this.gear);
                return;
            }
        }

        System.out.printf("A %sª marcha já está engatada.\n", this.gear);
    }

    public void accelerate() {
        if (!this.power) {
            System.out.println("Ligue o carro para poder acelerar");
            return;
        }

        switch (this.gear) {
            case 0 -> System.out.println("Coloque a primeira marcha para poder acelerar, pois o carro está em Neutro.");
            case 1 -> {
                this.velocity = this.velocity >= this.minVelocity && this.velocity < 20 ? ++this.velocity : this.velocity;
                System.out.printf("Acelerando.... vruuuuummmmm...\nVelocidade: %skm/h\nMarcha: %sª\n", this.velocity, this.gear);
                if (this.velocity == 20) {
                    System.out.println("Para acelerar mais avance para a 2ª marcha");
                }
            }
            case 2 -> {
                this.velocity = this.velocity >= 20 && this.velocity < 40 ? ++this.velocity : this.velocity;
                System.out.printf("Acelerando.... vruuuuummmmm...\nVelocidade: %skm/h\nMarcha: %sª\n", this.velocity, this.gear);
                if (this.velocity == 40) {
                    System.out.println("Para acelerar mais avance para a 3ª marcha");
                }
            }
            case 3 -> {
                this.velocity = this.velocity >= 40 && this.velocity < 60 ? ++this.velocity : this.velocity;
                System.out.printf("Acelerando.... vruuuuummmmm...\nVelocidade: %skm/h\nMarcha: %sª\n", this.velocity, this.gear);
                if (this.velocity == 60) {
                    System.out.println("Para acelerar mais avance para a 4ª marcha");
                }
            }
            case 4 -> {
                this.velocity = this.velocity >= 60 && this.velocity < 80 ? ++this.velocity : this.velocity;
                System.out.printf("Acelerando.... vruuuuummmmm...\nVelocidade: %skm/h\nMarcha: %sª\n", this.velocity, this.gear);
                if (this.velocity == 80) {
                    System.out.println("Para acelerar mais avance para a 5ª marcha");
                }
            }
            case 5 -> {
                this.velocity = this.velocity >= 80 && this.velocity < 100 ? ++this.velocity : this.velocity;
                System.out.printf("Acelerando.... vruuuuummmmm...\nVelocidade: %skm/h\nMarcha: %sª\n", this.velocity, this.gear);
                if (this.velocity == 100) {
                    System.out.println("Para acelerar mais avance para a 6ª marcha");
                }
            }
            case 6 -> {
                this.velocity = this.velocity >= 100 && this.velocity < this.maxVelocity ? ++this.velocity : this.velocity;
                System.out.printf("Acelerando.... vruuuuummmmm...\nVelocidade: %skm/h\nMarcha: %sª\n", this.velocity, this.gear);
                if (this.velocity == maxVelocity) {
                    System.out.println("O carro atingiu a velocidade máxima");
                }
            }
        }      
    }

    public void slowDown() {
        if (!this.power) {
            System.out.println("Carro desligado. Não a necessidade de desacelerar.");
            return;
        }

        this.velocity = this.velocity != this.minVelocity ? --this.velocity : this.minVelocity;

        if (this.velocity != this.minVelocity) {
            System.out.printf("Freando... vruuuummmm...\nVelocidade: %skm/h\n", this.velocity);
        } else {
            System.out.printf("Carro parado. Você já pode desligar.\nVelocidade: %skm/h\n", this.velocity);
        }


        if (this.velocity <= 100 && this.velocity > 80 && this.gear != 5) {
            this.gear = 5;
            System.out.println("Marcha: 5ª");
            return;
        }

        if (this.velocity <= 80 && this.velocity > 60 && this.gear != 4) {
            this.gear = 4;
            System.out.println("Marcha: 4ª");
            return;
        }

        if (this.velocity <= 60 && this.velocity > 40 && this.gear != 3) {
            this.gear = 3;
            System.out.println("Marcha: 3ª");
            return;
        }

        if (this.velocity <= 40 && this.velocity > 20 && this.gear != 2) {
            this.gear = 2;
            System.out.println("Marcha: 2ª");
            return;
        }

        if (this.velocity <= 20 && this.velocity > this.minVelocity && this.gear != 1) {
            this.gear = 1;
            System.out.println("Marcha: 1ª");
            return;
        }
        
        if (this.velocity == this.minVelocity && this.gear != 0) {
            this.gear = 0;
            System.out.println("Marcha: Neutro");
            return;
        }
    
    }

    public void toTurn(Scanner scanner) {
        if (this.velocity > 0 && this.velocity <= 40) {
            int direction = 0;
            while (direction != 1 && direction != 2) {
                System.out.println("Informe a direção:");
                System.out.println("[1-esquerda] [2-direita]");
                direction = Integer.parseInt(scanner.nextLine());
                if (direction != 1 && direction != 2) {
                    System.out.println("Opção inválda.");
                }
            }
            System.out.println(direction == 1 ? "Você fez uma curva à esquerda." : "Você fez uma curva à direita.");
            return;
        }

        System.out.println("O carro tem que estar ligado, em movimento e\ncom velocidade segura para realizar curvas.");
        System.out.println("Velocidade segura entre 1 e 40km/h");
    }

    public void toSwitchOff() {
        if (this.power && this.isDriverIntoCar && this.velocity == this.minVelocity && this.gear == 0) {
            this.power = false;
            System.out.printf("Análise de segurança...\nVelocidade: %skm/h\nMarcha: Neutro\nFreio de mão: Acionado.\n", this.velocity);
            System.out.println("O carro foi desligado.");
            return;
        }

        System.out.println("Para desligar o carro, este deve estar totalmente parado\ne com a marcha em Neutro.");
    }

    public void removeDriver() {
        if (driver != null && this.gear == 0 && !this.power) {
            driver = null;
            System.out.println("Gostou do passeio?\nVolte sempre...\nO motorista saiu do carro.");
            return;
        }

        if (driver == null) {
            System.out.println("O carro já está vazio. Aguardando motorista...");
            return;
        }

        System.out.println("O carro deve estar parado e desligado para você poder sair.");
    }
}
