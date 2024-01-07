import java.util.Random;

public abstract class BattleLoc extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;
    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }
    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("You are in the " + this.getName());
        System.out.println("Be careful ! There are " + monsterNumber +  this.getMonster() + " here !");
        System.out.println("<F>ight or <R>un !");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F") && combat(monsterNumber)){
            System.out.println("You won the battle in the " + this.getName() + " !");
            return true;
        }

        if (this.getPlayer().getHealth() <= 0){
            System.out.println("You are dead !");
            return false;
        }
        return true;
    }
    public boolean combat(int monsterNumber){
        for (int i = 1; i <= monsterNumber; i++ ){
            this.getMonster().setHealth(this.getMonster().getOrgHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("<H>it or <E>scape");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H")){
                    System.out.println("You hit the " + this.getMonster().getName() + " : " + this.getPlayer().getTotalDamage());
                    this.getMonster().setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0){
                        System.out.println(this.getMonster().getName() + " hit you : " + this.getMonster().getDamage());
                        int obstacleDamage = this.getMonster().getDamage() - this.getPlayer().getArmor().getBlock();
                        if (obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }else {
                    System.out.println("You escaped from the " + this.getMonster().getName());
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You won the battle !");
                System.out.println(this.getMonster().getAward() + " coin awarded to you !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Current Money : " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Your Health : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " Health : " + this.getMonster().getHealth());
        System.out.println("-------------------------------");
    }
    public void playerStats() {
        System.out.println("Player Stats");
        System.out.println("--------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon : " + this.getPlayer().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Armor : " + this.getPlayer().getArmor().getName());
        System.out.println("Block : " + this.getPlayer().getArmor().getBlock());
        System.out.println("Money : " + this.getPlayer().getMoney());
        System.out.println();

    }

    public void monsterStats(int i) {
        System.out.println(i + ". " + this.getMonster().getName() + " Stats");
        System.out.println("--------------------");
        System.out.println("Health : " + this.getMonster().getHealth());
        System.out.println("Damage : " + this.getMonster().getDamage());
        System.out.println("Award : " + this.getMonster().getAward());
    }
    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}