package arrays;

public class GenGenerator {
    public static int findTime(String genome, char mutation) {

        if (genome.indexOf(mutation) == -1) {
            return 0;
        }

        int timeAfterNoMoreRemoval = 0;

        StringBuilder sb = new StringBuilder(genome);

        boolean willRemove;

        while (sb.length() > 1) {

            willRemove = false;

            boolean[] toRemove = new boolean[sb.length()];

            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) == mutation) {
                    toRemove[i - 1] = true;
                    willRemove = true;
                }
            }

            if (!willRemove) {
                break;
            }

            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < sb.length(); i++) {
                if (!toRemove[i]) {
                    temp.append(sb.charAt(i));
                }
            }

            timeAfterNoMoreRemoval++;

            sb = temp;
        }


        return timeAfterNoMoreRemoval;

    }
}
