import java.util.Random;

public class Mine extends BattleLoc {

    public Mine(Player player) {
        super(player, "Maden", new Snake(), "Random Reward", new Random().nextInt(5) + 1);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are now in the Mine. Be careful, there are snakes here!");
        return super.onLocation();
    }

    @Override
    public boolean combat(int monsterNumber) {
        System.out.println("You encounter " + monsterNumber + " snakes!");

        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getOrgHealth());
            System.out.println(i + ". Snake!");

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<H>it or <R>un?");
                String choice = input.nextLine().toUpperCase();

                if (choice.equals("H")) {
                    // Combat mechanics
                    playerHitMonster();
                    if (this.getMonster().getHealth() > 0) {
                        monsterHitPlayer();
                    }
                } else if (choice.equals("R")) {
                    return false; // Player runs away
                }
            }

            if (this.getMonster().getHealth() <= 0) {
                System.out.println("You defeated the snake!");
                giveRandomReward();
            } else {
                System.out.println("You are defeated by the snake!");
                return false;
            }
        }

        return true;
    }

    private void playerHitMonster() {
        int damageDealt = this.getPlayer().getTotalDamage();
        this.getMonster().setHealth(this.getMonster().getHealth() - damageDealt);
        System.out.println("You hit the monster and dealt " + damageDealt + " damage.");
    }

    private void monsterHitPlayer() {
        int damage = this.getMonster().getDamage();
        this.getPlayer().setHealth(this.getPlayer().getHealth() - damage);
        System.out.println("The monster hits you and deals " + damage + " damage.");
    }

    private void giveRandomReward() {
        Random rand = new Random();
        int chance = rand.nextInt(100);

        if (chance < 15) {
            // Silah kazanma ihtimali
            int weaponChance = rand.nextInt(100);
            if (weaponChance < 50) {
                this.getPlayer().getInventory().addWeapon(new Weapon("Pistol", 1, 2, 25)); // %50 ihtimalle Tabanca
            } else if (weaponChance < 80) {
                this.getPlayer().getInventory().addWeapon(new Weapon("Sword", 2, 3, 35)); // %30 ihtimalle Kılıç
            } else {
                this.getPlayer().getInventory().addWeapon(new Weapon("Rifle", 3, 7, 45)); // %20 ihtimalle Tüfek
            }
        } else if (chance < 30) {
            // Zırh kazanma ihtimali
            int armorChance = rand.nextInt(100);
            if (armorChance < 50) {
                this.getPlayer().getInventory().addArmor(new Armor(1, "Light Armor", 1, 15)); // %50 ihtimalle Hafif Zırh
            } else if (armorChance < 80) {
                this.getPlayer().getInventory().addArmor(new Armor(2, "Medium Armor", 3, 25)); // %30 ihtimalle Orta Zırh
            } else {
                this.getPlayer().getInventory().addArmor(new Armor(3, "Heavy Armor", 5, 40)); // %20 ihtimalle Ağır Zırh
            }
        } else if (chance < 55) {
            // Para kazanma ihtimali
            int moneyChance = rand.nextInt(100);
            if (moneyChance < 50) {
                this.getPlayer().addMoney(1); // %50 ihtimalle 1 Para
            } else if (moneyChance < 80) {
                this.getPlayer().addMoney(5); // %30 ihtimalle 5 Para
            } else {
                this.getPlayer().addMoney(10); // %20 ihtimalle 10 Para
            }
        } else {
            System.out.println("You found nothing this time."); // %45 ihtimalle hiçbir şey kazanılmaz
        }
    }
}