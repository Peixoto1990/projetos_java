public class PetMachine {
    private Pet pet = null;
    private boolean isPetClean = false;
    private boolean isMachineClean = true;
    private static final int MAX_WATER = 30;
    private static final int MAX_SHAMPOO = 10;
    private static final int WATER_CONSUMED_BY_A_PET = 10;
    private static final int SHAMPOO_CONSUMED_BY_A_PET = 2;
    private static final int WATER_CONSUMED_FOR_MACHINE_CLEANING = 3;
    private static final int SHAMPOO_CONSUMED_FOR_MACHINE_CLEANING = 1;
    private static final int WATER_SUPPLY = 2;
    private static final int SHAMPOO_SUPPLY = 2;
    private int water = MAX_WATER;
    private int shampoo = MAX_SHAMPOO;

    private boolean isMachineEmpty() {
        return this.pet == null;
    }

    public void verifyMachine() {
        if (!this.isMachineEmpty()) {
            System.out.printf("O pet %s está no banho.\n", this.pet.name());
            return;
        }

        System.out.println("A máquina está vazia.");
    }

    public void putAPetInTheMachine(Pet pet) {
        this.pet = pet;

        System.out.printf("O pet %s está na máquina.\nPreparando para iniciar o banho...\n", this.pet.name());
    }

    public boolean isMachineBlocked() {
        if (!this.isMachineEmpty()) {
            System.out.println("A máquina só pode dar banho em um pet por vez.\nJá tem um pet na máquina.\nAguarda sua vez.");
            return  true;
        }

        if (!this.isMachineClean) {
            System.out.println("A máquina está suja.\nEla deve ser limpa antes de colocar o pet no banho.");
            return true;
        }

        return false;
    }

    public void checkWaterLevel() {
        System.out.printf("Nível de água: %sL\n", this.water);
    }

    public void checkShampooLevel() {
        System.out.printf("Nível de shampoo: %sL\n", this.shampoo);
    }

    public void removePetFromTheMachine() {
        if (this.isMachineEmpty()) {
            System.out.println("A máquina já está vazia.\nAguardando novo pet...");
            return;
        }

        if (!this.isPetClean) {
            this.pet = null;
            this.isMachineClean = false;
            System.out.println("Pedimos desculpas pelo ocorrido.\nResolveremos o problema.\nO próximo banho é por nossa conta.");
            return;
        }

        System.out.printf("O pet %s terminou seu banho e foi retirado da máquina.\n", this.pet.name());
        System.out.println("Agradecemos a preferência, volte sempre.");
        this.pet = null;
        this.isPetClean = false;
        this.isMachineClean = true;
    }

    private boolean isWaterFull() {
        return this.water == MAX_WATER;
    }
    
    private boolean isShampooFull() {
        return this.shampoo == MAX_SHAMPOO;
    }

    public void supplyWater() {
        if (this.isWaterFull()) {
            System.out.println("A máquina está com a capacidade de água no máximo.");
            System.out.println("Não é necessário abastecer.");
            return;
        }

        this.water = this.water < MAX_WATER && this.water != MAX_WATER - 1 ? this.water + WATER_SUPPLY : this.water + 1;
        System.out.printf("Abastecimento realizado.\nNível de água: %sL\n", this.water);
    }

    public void supplyShampoo() {
        if (this.isShampooFull()) {
            System.out.println("A máquina está com a capacidade de shampoo no máximo.");
            System.out.println("Não é necessário abastecer.");
            return;
        }

        this.shampoo = this.shampoo < MAX_SHAMPOO && this.shampoo != MAX_SHAMPOO - 1 ? this.shampoo + SHAMPOO_SUPPLY : this.shampoo + 1;
        System.out.printf("Abastecimento realizado.\nNível de shampoo: %sL\n", this.shampoo);
    }

    private boolean isEnoughWaterForAShower() {
        return this.water >= WATER_CONSUMED_BY_A_PET;
    }

    private boolean isEnoughShampooForAShower() {
        return this.shampoo >= SHAMPOO_CONSUMED_BY_A_PET;
    }

    private boolean isEnoughWaterForCleanTheMachine() {
        return this.water >= WATER_CONSUMED_FOR_MACHINE_CLEANING;
    }

    private boolean isEnoughShampooForCleanTheMachine() {
        return this.shampoo >= SHAMPOO_CONSUMED_FOR_MACHINE_CLEANING;
    }

    public void batheThePet() {
       if (this.isPetClean) {
           System.out.printf("O pet %s já está limpo.\nFavor libere a máquina.\n", this.pet.name());
           return; 
       }

    if (this.isMachineEmpty()) {
            System.out.println("A máquina está vazia.\nColoque o pet nela para dar banho.");
            return;
       }

       if (!this.isEnoughWaterForAShower()) {
            System.out.println("Nível de água abaixo do necessário para o banho.\nPor favor abasteça a máquina.");
            return;
       }

       if (!this.isEnoughShampooForAShower()) {
            System.out.println("Nível de shampoo abaixo do necessário para o banho.\nPor favor abasteça a máquina.");
            return;
       }

       System.out.println("Iniciando banho...");

       this.water -= WATER_CONSUMED_BY_A_PET;
       this.shampoo -= SHAMPOO_CONSUMED_BY_A_PET;
       this.isPetClean = true;

       System.out.println("Banho concluído. Favor, libere a máquina.");
    }

    public void cleanTheMachine() {
   
        if (this.isMachineClean) {
            System.out.println("A máquina já está limpa.");
            return;
        }

        if (!this.isEnoughWaterForCleanTheMachine()) {
            System.out.println("Nível de água abaixo do necessário para a limpeza.\nPor favor abasteça a máquina.");
            return;
        }

        if (!this.isEnoughShampooForCleanTheMachine()) {
            System.out.println("Nível de shampoo abaixo do necessário para a limpeza.\nPor favor abasteça a máquina.");
            return;
        }

        System.out.println("Iniciando limpeza...");

        this.water -= WATER_CONSUMED_FOR_MACHINE_CLEANING;
        this.shampoo -= SHAMPOO_CONSUMED_FOR_MACHINE_CLEANING;
        this.isMachineClean = true;

        System.out.println("Limpeza concluída.");
    }

}
