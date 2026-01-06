import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    List<Developer> developer = new ArrayList<>();
    public void addDeveloper(){
        developer.add();
    }
    public void removeDeveloper(){
        developer.remove();

    }
    public Developer findDeveloper(){
        return developer.containsAll();
    }
    public void printTeamOverview(){
        System.out.println(developer);
    }
    public Developer findBestDeveloperForSkill(){
        return null;
    }
    public Developer findDevelopersMeetingrequirements(){
        return null;
    }

}
