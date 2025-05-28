package arrays;

public class PrimeGame {

    public int getMinStarHealth(int [] power, int amour) {

        int health = amour;
        int initialHealth = 0;

        for (int j : power) {

            if (health > 0) {
                health -= j;
                if (health < 0) {
                    initialHealth = Math.abs(health);
                }
            } else {
                initialHealth += j;
            }

        }

        return initialHealth + 1;

    }

    public static void main(String[] args) {}

}
