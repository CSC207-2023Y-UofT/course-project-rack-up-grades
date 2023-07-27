import java.util.ArrayList;
import java.util.Arrays;

public class LeaderboardPresenter implements InterfaceLeaderboardPresenter{
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
            i++;
            subarr.add(i);
            subarr.addAll(new ArrayList<>(Arrays.asList(s.split(","))));
            arr.add(subarr);
            subarr = new ArrayList<>();
        }
        ArrayList<Object[]> r = new ArrayList<>();
        for (ArrayList<Object> a : arr) {
            r.add(a.toArray());

        }
        Object[][] ret = (Object[][]) r.toArray();
        v.setData(ret);
    }
}
