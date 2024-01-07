public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean onLocation() {
        System.out.println("---- Welcome to the Tool Store. ----");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Exit");
            System.out.print("Please select an option to continue: ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Invalid option! Please select a valid option to continue: ");
                selectCase = Location.input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("You are exiting the Tool Store.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon() {
        System.out.println("----- Weapons -----");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " Price: " + w.getPrice() + " Damage: " + w.getDamage());
        }
        System.out.println("0 - Exit");
    }
    public void buyWeapon() {
        System.out.print("Please select a weapon to buy: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Invalid option! Please select a valid option to continue: ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money to buy this weapon.");
                } else {
                    //Satın alma
                    System.out.println("You have bought " + selectedWeapon.getName() + " weapon.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your current balance: " + balance);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }
    public void printArmor() {
        System.out.println("----- Armors -----");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " Price: " + a.getPrice() + " Block: " + a.getBlock());
        }
        System.out.println("0 - Exit");
    }
    public void buyArmor() {
        System.out.print("Please select an armor to buy: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Invalid option! Please select a valid option to continue: ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money to buy this armor.");
                } else {
                    //Satın alma
                    System.out.println("You have bought " + selectedArmor.getName() + " armor.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your current balance: " + balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}