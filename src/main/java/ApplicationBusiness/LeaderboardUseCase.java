package ApplicationBusiness;

import FrameworksAndDrivers.DataAccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeaderboardUseCase {


    final String fs = System.getProperty("file.separator");
    final String FILE = System.getProperty("user.dir")+fs+"src"+fs+"main"+fs+"JAVA"+fs+ "FrameworksAndDrivers/file.txt";

    private final DataAccessInterface DataAccIn = new DataAccess(FILE);

    private String name;

    private int score;
    private String diff;
    private InterfaceLeaderboardPresenter lp;

    /**
     * create an instance of this class
     * @param useCase
     * @param lp
     */
    public LeaderboardUseCase(GameUseCase useCase, InterfaceLeaderboardPresenter lp) {
        this.score = useCase.getScore();
        this.diff = useCase.getDifficulty();
        this.lp = lp;

    }


    /**
     * Set the name as the name given through assignment
     * @param name: string
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Add to leaderboard, it will read the data from the file using DataAccess read() through the interface
     * which is an ArrayList of string being per line of file.txt
     * it will process and add the new name, score, difficulty to the ArrayList and remove the 10th+ person if it exists
     * then write that to the file using DataAccess write() through the interface
     */
    public void addToLeaderboard() {
        ArrayList<String> data = this.DataAccIn.read();
        ArrayList<Integer> mod = new ArrayList<>();

        if (!this.name.equals("")) {
            for (String s : data) {
                String[] temp = s.split(",");
                mod.add(Integer.parseInt(temp[1]));
            }

            this.name = this.name.replaceAll(",", "");

            // Cut the name to 8 letters if longer
            if (this.name.length() >= 8){
                this.name = this.name.substring(0, 7);
            }

            data.add(name + "," + score + "," + diff);

            class dataComparator implements Comparator<String> {
                public int compare(String e1, String e2) {
                    if (Integer.parseInt(e1.split(",")[1]) < Integer.parseInt(e2.split(",")[1])) {
                        return 1;
                    }
                    else if (Integer.parseInt(e1.split(",")[1]) > Integer.parseInt(e2.split(",")[1])) {
                        return -1;
                    }
                    else {
                        return 0;
                    }

                }
            }
            Collections.sort(data, new dataComparator());

            if (data.size() > 10) {
                data.remove(data.size() - 1);
            }

            this.DataAccIn.write(data);
        }
    }


    /**
     * set the data on the leaderboard presenter through the interface
     */
    public void setData() {
        this.lp.setData(this.DataAccIn.read());
    }
}
