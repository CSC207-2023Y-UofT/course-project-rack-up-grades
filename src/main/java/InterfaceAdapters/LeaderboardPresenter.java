package InterfaceAdapters;

import ApplicationBusiness.InterfaceLeaderboardPresenter;

import java.util.ArrayList;
import java.util.Arrays;

public class LeaderboardPresenter implements InterfaceLeaderboardPresenter {
    private ViewModel v;

    public LeaderboardPresenter(ViewModel v) {
        this.v = v;
    }

    @Override
    public void setData(ArrayList<String> data) {
        ArrayList<ArrayList<Object>> arr = new ArrayList<>();
        ArrayList<Object> subarr = new ArrayList<>();
        Integer i = 0;
        // convert ["Cathy,90,e", "Ivy,80,m"] to ->
        // [[1, "Cathy", "90", "Easy"], [2, "Ivy", "80", "Medium"]] to ->
        // {{1, "Cathy", "90", "Easy"}, {2, "Ivy", "80", "Medium"}}
        for (String s : data) {
            char k = s.charAt(s.length()-1);
            switch (k) {
                case 'e':
                    s = s.substring(0,s.length()-1) + "Easy";
                    break;
                case 'm':
                    s = s.substring(0,s.length()-1) + "Medium";
                    break;
                case 'h':
                    s = s.substring(0,s.length()-1) + "Hard";
                    break;
            }

            i++;
            subarr.add(i);
            subarr.addAll(new ArrayList<>(Arrays.asList(s.split(","))));
            arr.add(subarr);
            subarr = new ArrayList<>();
        }
        Object[][] arr2 = new Object[arr.size()][];
        for (int a = 0; a < arr.size(); a++) {
            arr2[a] = arr.get(a).toArray(new Object[0]);
        }
        v.setData(arr2);
    }
}
