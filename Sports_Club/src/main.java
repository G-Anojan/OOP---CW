import java.text.ParseException;

public class main {
    public static void run() {
        javafx.application.Application.launch(SportsGui.class);
    }
    public static void main(String[]args) throws ParseException {

        int i = 0;
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadFromFile();
               while (true) {
            String option = premierLeagueManager.menu();
            //launch(args);
            switch (option) {
                case "A":
                case "a":
                    premierLeagueManager.addClub();
                    break;
                case "D":
                case "d":
                    premierLeagueManager.deltClub();
                    break;
                case "O":
                case "o":
                    premierLeagueManager.oneTeamDetail();
                    break;
                case "V":
                case "v":
                    premierLeagueManager.display();
                    break;
                case "P":
                case "p":
                    premierLeagueManager.addPlayedMatch();
                    break;
                case "S":
                case "s":
                   premierLeagueManager.saveInFile();
                    System.out.println("Successfully Saved in File !!!!!! ");
                   break;
                case "G":
                case "g":
                   run();
                    break;
                case "E":
                case "e":
                    premierLeagueManager.exit();
                    break;
                default:
                    System.out.println("Enter the Option Correctly !!! ");
            }
        }
    }
}
