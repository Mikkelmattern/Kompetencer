import java.util.*;

public class Main {
    public static List<Developer> findDevs(List<Team> teams, Map<String, Integer> reqs) {
        List<Developer> result = new ArrayList<>();
        for (Team t : teams) {
            for (Developer d : t.getDeveloperTeam()) {
                if (d.meetsRequirements(reqs)) {
                    result.add(d);
                }
            }
        }
        return result;
    }

    public Team biggestTeam(List<Team> t) {
        if(t.isEmpty()){
            return null;
        }
        Team biggest = t.get(0);
        for (Team te : t) {
            if ((te.getDeveloperTeam().size() > biggest.getDeveloperTeam().size())) {
                biggest = te;
            }
        }
        return biggest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Team> teamList = new ArrayList<>();
        List<String> teamListString = new ArrayList<>();
        while (true) {
            System.out.println("1: Se teams\n2: Tilføj team\n3: Se alle udviklere");
            String choice = sc.nextLine();

            while (!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("3"))) {
                System.out.println("Vælg 1, 2 eller 3");
                choice = sc.nextLine();
            }
            switch (choice) {
                case "1": {
                    if (teamList.size() == 0) {
                        System.out.println("Ingen teams oprettet");
                        break;
                    }
                    System.out.println(teamListString + "\nVælg team");
                    choice = sc.nextLine();
                    for (Team t : teamList) {
                        if (t.getName().equalsIgnoreCase(choice)) {
                            t.printTeamOverview();


                            System.out.println("Vælg handling\n1: Vælg udvikler\n2: Tilføj udvikler");
                            choice = sc.nextLine();
                            while (!(choice.equals("1") || choice.equals("2"))) {
                                System.out.println("Vælg 1 eller 2");
                                choice = sc.nextLine();
                            }
                            switch (choice) {
                                case "1": {
                                    if (t.getDeveloperTeam().isEmpty()) {
                                        System.out.println("Ingen medlemmer på teamet");
                                        break;
                                    }
                                    System.out.println(t.getDeveloperTeam());
                                    while (!(choice.equals("1") || choice.equals("2"))) {
                                        System.out.println("Vælg 1 eller 2");
                                        choice = sc.nextLine();
                                    }

                                    for (Developer d : t.getDeveloperTeam()) {
                                        System.out.println("Hvilken udvikler vil du vælge");
                                        choice = sc.nextLine();
                                        if (choice.equalsIgnoreCase(d.getName())) {
                                            System.out.println("Vælg handling\n1: Tilføj skill\n2: Ændre skill\n3: Tilbage");
                                            while (true) {
                                                String choice1 = sc.nextLine();
                                                while (!((choice1.equals("1") || choice1.equals("2") || choice1.equals("3")))) {
                                                    System.out.println("Vælg 1,2 eller 3");
                                                }
                                                if (choice1.equals("1")) {
                                                    choice1 = sc.nextLine();
                                                    System.out.println("Hvilket skill vil du tilføje?");
                                                    choice1 = sc.nextLine();
                                                    d.addSkill(choice1);
                                                    break;
                                                }
                                                if (choice1.equals("2")) {
                                                    System.out.println(d.showSkills());
                                                    System.out.println("Vælg et skill at ændre");
                                                    choice1 = sc.nextLine();
                                                    for (Skill s : d.showSkills()) {
                                                        int placement = 0;
                                                        if (choice1.equals(s.getName())) {
                                                            while (true) {
                                                                System.out.println("Hvad niveu skal det sættes til? (1-10)");
                                                                while (true) {
                                                                    choice1 = sc.nextLine();
                                                                    try {
                                                                        int i = Integer.parseInt(choice1);
                                                                        if (i >= 0 && i <= 10) {
                                                                            d.updateSkillLevel(s.getName(), placement, i);
                                                                            break;
                                                                        }


                                                                    } catch (NumberFormatException e) {
                                                                        System.out.println("Vælg et tal mellem 1-10");

                                                                    }
                                                                }
                                                            }
                                                        }
                                                        placement++;
                                                    }

                                                }
                                            }


                                        }
                                        break;
                                    }
                                }
                                case "2": {

                                    System.out.println("Vælg navn");
                                    String choice3 = sc.nextLine();
                                    t.addDeveloper(choice3);
                                    break;
                                }
                            }

                        } else System.out.println("Valgte team findes ikke");

                    }
                    break;
                }
                case "2": {
                    System.out.println("Hvad skal teamets navn være?");
                    String choice2 = sc.nextLine();
                    Team newTeam = new Team(choice2);
                    teamList.add(newTeam);
                    teamListString.add(choice2);
                }
                case "3": {
                    for (Team t : teamList) {
                        t.printTeamOverview();
                    }
                }
                case "4": {
                    System.out.println("Vælg et skill for at finde met kompetente udvikler");
                    String choice4 = sc.nextLine();
                    Developer mostComp = null;
                    int mostCompLevel = 0;
                    for (Team t : teamList) {
                        for (Developer d : t.getDeveloperTeam()) {
                            for (Skill s : d.showSkills()) {
                                if (choice4.equalsIgnoreCase(s.getName()) && s.getLevel() > mostCompLevel) {
                                    mostCompLevel = s.getLevel();
                                    mostComp = d;
                                }
                            }
                        }
                    }
                    if (mostComp == null) {
                        System.out.println("Ingen udvikler har skill: " + choice4);
                    } else {
                        System.out.println("Mest kompetente: " + mostComp.getName() + " (level " + mostCompLevel + ")");
                    }
                }
                case "5": {
                    Map<String, Integer> req = new HashMap<>();
                    req.put("Java", 3);
                    req.put("SQL", 2);

                    List<Developer> matches = findDevs(teamList, req);

                    if (matches.isEmpty()) {
                        System.out.println("Ingen udviklere matcher kravene");
                    } else {
                        System.out.println(matches);
                    }
                }

            }
        }
    }
}
