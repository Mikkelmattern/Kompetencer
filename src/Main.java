import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Team> teamList = new ArrayList<>();
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
                        System.out.println("Vælg teammedlem");
                        t.printTeamOverview();
                        System.out.println("Vælg udvikler");
                        choice = sc.nextLine();
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
                                            if (choice.equals(s.getName())) {
                                                while (true) {
                                                    System.out.println("Hvad niveu skal det sættes til? (1-10)");
                                                    choice = sc.nextLine();

                                                    try {
                                                       int i = Integer.parseInt(choice);
                                                        if(i < 0 )


                                                    } catch (NumberFormatException e) {

                                                    }
                                                }
                                            }
                                        }

                                    }
                                }

                            }
                        }

                    } else System.out.println("Valgte team findes ikke");

                }
            }

        }
    }
}
