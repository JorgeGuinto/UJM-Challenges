import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team> {
    public String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team) {
        if (this.league.contains(team)) {
            return false;
        } else {
            league.add(team);
            return  true;
        }
    }

    public void showLeagueTable () {
        Collections.sort(league);

        for (int i = 0; i < league.size(); i++) {
            System.out.println(league.get(i).getName() + ": " + league.get(i).ranking());
        }
    }
}
