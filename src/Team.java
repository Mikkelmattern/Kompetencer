import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    List<Developer> developer = new ArrayList<>();

    public void addDeveloper(String name) {
        developer.add(new Developer(name));
    }

    public void removeDeveloper() {
        //  developer.remove();

    }

    public Developer findDeveloper() {
        // return developer.containsAll();
        return null;
    }

    public List<Developer> getDeveloperTeam() {
        return developer;
    }

    public void printTeamOverview() {
        System.out.println(developer);
    }

    public Developer findBestDeveloperForSkill() {
        return null;
    }

    public Developer findDevelopersMeetingrequirements() {
        return null;
    }

    public String getName() {
        return name;
    }

}
