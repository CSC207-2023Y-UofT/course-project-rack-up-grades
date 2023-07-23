import java.util.*;

public class Timer {

    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("1P");
        lst.add("2N");
        lst.add("3P");
        java.util.Timer T = new java.util.Timer();
        TimerTask TT = new TimerTask() {

            @Override
            public void run() {

                if (!lst.isEmpty()) {
                    System.out.println(lst.remove(0));
                }
                else {
                    System.out.println("Game Over");
                    T.cancel();
                }
            }
        };
        T.scheduleAtFixedRate(TT, 3000, 1000);
    }
}
