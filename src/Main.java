import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Team> teamList = new ArrayList<>();

        while (true) {
            System.out.println("1: Se teams\n2:Tilføj team");
            String choice = sc.nextLine();

            while (!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2"))) {
                System.out.println("Vælg 1 eller 2");
                choice = sc.nextLine();
            }
            switch (choice) {
                case "1": {
                    if (teamList.size() == 0) {
                        System.out.println("Ingen teams oprettet");
                        break;
                    }
                    System.out.println(teamList + "\nVælg team");
                    choice = sc.nextLine();
                    for (Team t : teamList) {
                        if (t.getName().equalsIgnoreCase(choice)) {
                            t.printTeamOverview();


                            System.out.println("Vælg handling\n1: Vælg udvikler\nTilføj udvikler");
                            choice = sc.nextLine();
                            while (!((choice == "1") || (choice == "2"))) {
                                System.out.println("Vælg 1 eller 2");
                            }
                            switch (choice) {
                                case "1": {
                                    if (t.getDeveloperTeam().isEmpty()) {
                                        System.out.println("Ingen medlemmer på teamet");
                                        break;
                                    }
                                    for (Developer d : t.getDeveloperTeam()) {
                                        if (choice.equalsIgnoreCase(d.getName())) {
                                            System.out.println("Vælg handling\n\n1: tilføj skill\n2: ændre skill\n3: tilbage");
                                            while (true) {
                                                choice = sc.nextLine();
                                                while (!((choice.equals("1") || choice.equals("2") || choice.equals("3")))) {
                                                    System.out.println("Vælg 1,2 eller 3");
                                                }
                                                if (choice.equals("1")) {
                                                    choice = sc.nextLine();
                                                    System.out.println("Hvilket skill vil du tilføje?");
                                                    d.addSkill(choice);
                                                }
                                                if (choice.equals("2")) {
                                                    System.out.println(d.showSkills());
                                                    System.out.println("Vælg et skill at ændre");
                                                    choice = sc.nextLine();
                                                    for (Skill s : d.showSkills()) {
                                                        int placement = 0;
                                                        if (choice.equals(s.getName())) {
                                                            while (true) {
                                                                System.out.println("Hvad niveu skal det sættes til? (1-10)");
                                                                choice = sc.nextLine();

                                                                try {
                                                                    int i = Integer.parseInt(choice);
                                                                    if (i >= 0 && i <= 10) {
                                                                        d.updateSkillLevel(s.getName(), placement, i);
                                                                    }


                                                                } catch (NumberFormatException e) {

                                                                }
                                                            }
                                                        }
                                                        placement++;
                                                    }

                                                }
                                            }

                                        }
                                    }
                                } case "2":{
                                    System.out.println("Vælg navn");
                                    choice = sc.nextLine();
                                    t.addDeveloper(choice);
                                }
                            }

                        } else System.out.println("Valgte team findes ikke");

                    }
                    break;
                }
                case "2": {
                    System.out.println("Hvad skal teamets navn være?");
                    choice = sc.nextLine();
                    Team newTeam = new Team(choice);
                    teamList.add(newTeam);
                }
                default:
                    break;

            }
        }
    }
}
