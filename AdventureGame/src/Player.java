import java.util.Scanner;

public class Player {
    private Armor armor;
    private Weapon weapon;
    private String charName;
    private String name;
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar(){

        GameChar[] charList = {new Samurai(), new Knight(), new Archer()};
        for (GameChar gameChar : charList) {
            System.out.println(gameChar.getId()+"." +gameChar.getName() +
                    " \t Damage : " + gameChar.getDamage() +
                    " \t Health : " + gameChar.getHealth() +
                    " \t Money : " + gameChar.getMoney());
            System.out.println("########################################################");
        }
        System.out.println("Please select your character : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Knight());
                break;
            case 3:
                initPlayer(new Archer());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Your Character " + this.getCharName() +
                " Damage : " + this.getDamage()+
                " Health : " + this.getHealth() +
                " Money : " + this.getMoney());
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Player Name : " + this.getName() +
                " Weapon : " + this.getInventory().getWeapon().getName() +
                " Armor : " + this.getInventory().getArmor().getName() +
                " Block : " + this.getInventory().getArmor().getBlock() +
                " Damage : " + this.getTotalDamage() +
                " Health : " + this.getHealth() +
                " Money : " + this.getMoney());
    }
    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
    public int getTotalDamage() {
        return this.damage + this.inventory.getWeapon().getDamage();
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getMoney(){
        return this.money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Inventory getInventory(){
        return this.inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
    public Armor getArmor(){
        return this.getInventory().getArmor();
    }
    public int getOriginalHealth(){
        return this.originalHealth;
    }
    public void setOriginalHealth(int originalHealth){
        this.originalHealth = originalHealth;
    }
    public void addMoney(int amount) {
        this.money += amount;
        System.out.println("You have gained " + amount + " coins.");
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

