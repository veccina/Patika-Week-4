import java.util.Scanner;
public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to the Adventure Game !");
        System.out.print("Please enter your name : ");
        String playerName = input.nextLine();
        Player newPlayer = new Player(playerName);
        System.out.println("Welcome " + newPlayer.getName()+ " to the Adventure Game !");
        System.out.println("You are in a land full of dangers. You should find the treasures before the monsters find you !");
        System.out.println("But first, you should select your character. Here are the characters :");
        System.out.println("##################### Characters #####################");
        newPlayer.selectChar();

        Location location = null;
        while (true){
            newPlayer.printInfo();
            System.out.println();
            System.out.println("##################### Locations #####################");
            System.out.println();
            System.out.println("1. Safe House (There is no monsters, you can rest here.)");
            System.out.println("2. Tool Store (You can buy weapons and armors here.)");
            System.out.println("3. Cave -- Prize: Food (Be careful ! There are zombies here !)");
            System.out.println("4. Forest -- Prize: Firewood (Be careful ! There are vampires here !)");
            System.out.println("5. River -- Prize:Water (Be careful ! There are bears here !)");
            System.out.println("0. Exit (If you exit, you will lose the game.)");
            System.out.println("Please select a location :");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(newPlayer);
                    break;
                case 2:
                    location = new ToolStore(newPlayer);
                    break;
                case 3:
                    location = new Cave(newPlayer);
                    break;
                case 4:
                    location = new Forest(newPlayer);
                    break;
                case 5:
                    location = new River(newPlayer);
                    break;
                default:
                    System.out.println("Invalid Location ! Please enter a valid location !");
            }
            if (location == null){
                System.out.println("Game is over !");
                break;
            }
            if (!location.onLocation()){
                System.out.println("You are Dead. Game is over !");
                break;
            }
        }
    }
}
