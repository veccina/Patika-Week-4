import java.util.Random;

public class Snake extends Monster {
    public Snake() {
        super(4, "Snake", getRandomDamage(), 12, 0); // ID: 4, Sağlık: 12, Para: Yok
    }

    private static int getRandomDamage() {
        return new Random().nextInt(4) + 3; // 3 ile 6 arasında rastgele hasar
    }
}