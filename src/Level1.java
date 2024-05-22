import java.util.Arrays;

public class Level1 {
    public static boolean Football(int F[], int N) {
        int[] copy = F.clone();
        Arrays.sort(copy);

        if (firstTry(F, copy)) return true;

        int[] copyReverse = reverse(F);

        if (secondTry(F, copyReverse, copy)) return true;

        if (Arrays.equals(F, copy)) return true;

        return false;
    }
    public static boolean firstTry (int[] F, int[] copy) {
        int flag = 0;
        for (int x = 0; x < F.length; x++) {
            if (F[x] != copy[x]) {
                flag++;
            }
            if (flag > 2) return false;
        }
        return true;
    }
    public static boolean secondTry (int[] F, int[] copyReverse, int[] copy) {
        int[] input = F.clone();
        int flag = 0;

        for (int x = 0; x < F.length; x++) {
            if (input[x] != copy[x] && flag == 0) {
                input = copyReverse.clone();
                flag++;
                x--;
            }
            else if (input[x] != copy[x] && flag == 1) {
                input = F.clone();
                flag++;
                x--;
            }
            else if (input[x] != copy[x] && flag >= 2) return false;
        }
        return true;
    }
    public static int[] reverse (int[] F) {
        int[] copyReverse = new int[F.length];
        int reserve;
        for (int x = 0; x < F.length; x++) {
            reserve = F[x];
            copyReverse[x] = F[F.length - 1 - x];
            copyReverse[F.length - 1 - x] = reserve;
        }
        return copyReverse;
    }
}

