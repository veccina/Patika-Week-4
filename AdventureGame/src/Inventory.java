public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon("Fist", -1, 0, 0);
        this.armor = new Armor(-1, "None", 0, 0);
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public void addArmor(Armor armor) {
        this.armor = armor;
        System.out.println("You have equipped " + armor.getName());
    }

    public void addWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println("You have equipped " + weapon.getName());
    }
}
