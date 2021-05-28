import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {
    int Checker = 0;

    Scanner sc = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);
    //create array lists
    public static ArrayList<FootballClub> footballClubList = new ArrayList<>();
    public static ArrayList<Match> sportsList = new ArrayList<>();

    @Override
    public String menu() {
//Show menu to user
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------|| Premier League ||-----------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Press A to Add a new club : ");
        System.out.println("Press D to Delete an existing club : ");
        System.out.println("Press O to Display Selected Team Statistics : ");
        System.out.println("Press V to Display all teams : ");
        System.out.println("Press P to Add a Played match : ");
        System.out.println("Press S to Save details in File : ");
        System.out.println("Press G to View GUI : ");
        System.out.println("Press E to Exit menu : ");
        System.out.println("Enter Your Option : ");

//get option from user
        String option = sc.next();
        return option;
    }

    @Override
    public void addClub() {
//input club name
        System.out.println("Enter the New Football Club Name : ");
        String clubName = "";
        clubName += scan.nextLine();
// check this club name exist or not
        for (FootballClub footballClubs : footballClubList) {
            if (footballClubs.getSportsClubName().equals(clubName)) {
                System.out.println("You Entered Team name Already exist !!!!!!!  Add club with new name");
                System.out.println("Enter the New Football Club Name : ");
                clubName = "";
                clubName += scan.nextLine();
//recheck club name already exist or not
                for (FootballClub footballClubs1 : footballClubList) {
                    if (footballClubs.getSportsClubName().equals(clubName)) {
                        System.out.println("You repeatedly enter exist Club Name !!!!!!!");
                        menu();
                    }
                }

            }

        }
//get location from user
        System.out.println("Enter the New club Location : ");
        String clubLocation = "";
        clubLocation += scan.nextLine();

//add to list
        FootballClub footballClub = new FootballClub();
        footballClub.setSportsClubName(clubName);
        footballClub.setLocation(clubLocation);
        footballClubList.add(footballClub);

//print Success massage
        System.out.println("Successfully New Team Added !!!!!! ");
//to show the teams details table
        display();

//to save newly added team in file
        saveInFile();
    }

    @Override
    public void deltClub() {
//variable for check name available or not

//input club name
        System.out.println("Enter the Club Name : ");
        String clubName = "";
        clubName += scan.nextLine();
// search club name
        for (int i = 0; i < footballClubList.size(); i++) {
            this.Checker = 1;
            if (footballClubList.get(i).getSportsClubName().equals(clubName)) {
                footballClubList.remove(footballClubList.get(i));
                System.out.println("Successfully Team " + clubName + " Deleted From League !!!!!!");
                saveInFile();
            }
        }
        if (this.Checker != 0) {
            System.out.println("Enter the Team name correctly !!!!!!!!!!!!");

        }
//to show the teams details table
        display();

//to update the file
        saveInFile();
    }

    @Override
    public void oneTeamDetail() {

//input club name
        System.out.println("Enter the Team Name : ");
        String clubName = "";
        clubName += scan.nextLine();
        System.out.println("Name\t|Location\t\t|Wins\t|Lost\t|Draw\t|Points\t|Matchs\t|RG\t|SG\t|GD ");
        for (FootballClub footballClub1 : footballClubList) {
            this.Checker = 1;
            if (footballClub1.getSportsClubName().equals(clubName))
                System.out.println(footballClub1.getSportsClubName() + "\t\t|" + footballClub1.getLocation() + "\t\t\t|" + footballClub1.getWins() + "\t\t|" + footballClub1.getDefeats() + "\t\t|" + footballClub1.getDraws() + "\t\t|" + footballClub1.getNo_of_points() + "\t\t|" + footballClub1.getPlayed_matches() + "\t\t|" + footballClub1.getRecevied_goles() + "\t|" + footballClub1.getScored_goles() + "\t|" + footballClub1.getGoles_difer());
        }
        if (this.Checker != 1) {
            System.out.println("Enter the Club name Correctly !!!!!!!! ");
        }
    }

    @Override
    public void display() {
        points_oder();
// for table view
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Name\t\t|Location\t\t|Wins\t|Lost\t|Draw\t|Points\t|Matchs\t|RG\t|SG\t|GD ");
        for (FootballClub footballClub1 : footballClubList) {
            System.out.println(footballClub1.getSportsClubName() + "\t\t\t|"+ footballClub1.getLocation() + "\t\t\t|"+ footballClub1.getWins() + "\t\t|"+footballClub1.getDefeats() + "\t\t|"+ footballClub1.getDraws() + "\t\t|"+ footballClub1.getNo_of_points() + "\t\t|"+ footballClub1.getPlayed_matches() + "\t\t|"+ footballClub1.getRecevied_goles() + "\t|"+ footballClub1.getScored_goles() + "\t|"+ footballClub1.getGoles_difer());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public void points_oder() {
//sorting in dicending oder by points
        Collections.sort(footballClubList, Comparator.comparingInt(FootballClub::getNo_of_points).reversed());
    }
    @Override
    public void wins_oder() {
//sorting in dicending oder by wins count
        Collections.sort(footballClubList, Comparator.comparingInt(FootballClub::getWins).reversed());
    }

    @Override
    public void goles_scored_oder() {
//sorting in dicending oder by Scored goles counts
        Collections.sort(footballClubList, Comparator.comparingInt(FootballClub::getScored_goles).reversed());
    }

    @Override
    public void random() {
// add a random football match
        int played = 1, win = 1, lose = 1, draw = 1, points = 10, halfPoints = 5;

//create 2 random numbers
        Random random1 = new Random();
        Random random2 = new Random();
//set limit to random numbers
        int rad1 = random1.nextInt(footballClubList.size());
        int rad2 = random2.nextInt(footballClubList.size());

        System.out.println("1 - " + rad1 + "\n 2 : " + rad2);
        if (rad1 !=  rad2) {
            for (int i = 0; i < footballClubList.size(); i++) {
                if (footballClubList.get(i).getSportsClubName() == footballClubList.get(rad1).getSportsClubName()) {
                    System.out.println("Club 1 : " + footballClubList.get(i).getSportsClubName());
                    for (int j = 0; j < footballClubList.size(); j++) {
                        if (footballClubList.get(j).getSportsClubName() == footballClubList.get(rad2).getSportsClubName()) {
//System.out.println("Club 1 : " + footballClubList.get(j).getSportsClubName());
                            String club_1 = footballClubList.get(i).getSportsClubName();
                            String club_2 = footballClubList.get(i).getSportsClubName();
                            int gol1 = random1.nextInt(10);
                            int gol2 = random2.nextInt(10);
                            System.out.println(gol1 + "\n" + gol2);

//add played match counts
                            footballClubList.get(i).setPlayed_matches(footballClubList.get(i).getPlayed_matches() + played);
                            footballClubList.get(j).setPlayed_matches(footballClubList.get(j).getPlayed_matches() + played);

//set scores to each teams
                            footballClubList.get(i).setScored_goles(footballClubList.get(i).getScored_goles() + gol1);
                            footballClubList.get(i).setRecevied_goles(footballClubList.get(i).getRecevied_goles() + gol2);
                            footballClubList.get(j).setScored_goles(footballClubList.get(j).getScored_goles() + gol2);
                            footballClubList.get(j).setRecevied_goles(footballClubList.get(j).getRecevied_goles() + gol1);

// set scores differences to each teams
                            footballClubList.get(i).setGoles_difer(footballClubList.get(i).getScored_goles() - footballClubList.get(i).getRecevied_goles());
                            footballClubList.get(j).setGoles_difer(footballClubList.get(j).getScored_goles() - footballClubList.get(j).getRecevied_goles());

// set win,lose and draw counts
                            if (gol1 < gol2) {
                                footballClubList.get(i).setDefeats(footballClubList.get(i).getDefeats() + lose);
                                footballClubList.get(j).setWins(footballClubList.get(j).getWins() + win);
                            } else if (gol1 > gol2) {
                                footballClubList.get(i).setWins(footballClubList.get(i).getWins() + win);
                                footballClubList.get(j).setDefeats(footballClubList.get(j).getDefeats() + lose);
                            } else {
                                footballClubList.get(i).setDraws(footballClubList.get(i).getDraws() + draw);
                                footballClubList.get(j).setDraws(footballClubList.get(j).getDraws() + draw);
                            }
//set points to each teams
                            footballClubList.get(i).setNo_of_points((footballClubList.get(i).getWins() * points) + (footballClubList.get(i).getDraws() * halfPoints));
                            footballClubList.get(j).setNo_of_points((footballClubList.get(j).getWins() * points) + (footballClubList.get(j).getDraws() * halfPoints));
                        }
                    }
                }
            }
        } else {
//if random number comes same this message shown
            System.out.println("Some thing Error Try Again !!!!!!!!!!!!!!!!!!!!");
        }
    }

    @Override
    public void addPlayedMatch() {
        loadMatchFile();

        int played = 1, win = 1, lose = 1, draw = 1, points = 10, halfPoints = 5;
//enter team names and goals
        System.out.println("Enter Played Teams Names : ");
        String clubName1 = "";
        String clubName2 = "";
        String dat = "";
        clubName1 += scan.nextLine();
        System.out.println(" Vs ");
        clubName2 += scan.nextLine();
//get date
        System.out.println("Enter The date (DD/MM/YYYY): ");
        dat = sc.next();
//get scores
        System.out.println(clubName1 + " Score : ");
        int club1Score = sc.nextInt();
        System.out.println(clubName2 + " Score : ");
        int club2Score = sc.nextInt();

        for (FootballClub footballClub1 : footballClubList) {
            if (footballClub1.getSportsClubName().equals(clubName1)) {
                for (FootballClub footballClub2 : footballClubList) {
                    if (footballClub2.getSportsClubName().equals(clubName2)) {
//add a match details in list
                        Match match = new Match();
                        match.setDate(dat);
                        match.setFirstTeam(clubName1);
                        match.setSecondTeam(clubName2);
                        match.setFirstTeamScor(club1Score);
                        match.setSecondTeamScor(club2Score);
                        sportsList.add(match);
// write a matchlist in text file
                        matchFile();
//Set played match count
                        footballClub1.setPlayed_matches(footballClub1.getPlayed_matches() + played);
                        footballClub2.setPlayed_matches(footballClub2.getPlayed_matches() + played);

//Set scored and received goals counts
                        footballClub1.setScored_goles(footballClub1.getScored_goles() + club1Score);
                        footballClub1.setRecevied_goles(footballClub1.getRecevied_goles() + club2Score);
                        footballClub2.setScored_goles(footballClub2.getScored_goles() + club2Score);
                        footballClub2.setRecevied_goles(footballClub2.getRecevied_goles() + club1Score);

//set goals difference
                        footballClub1.setGoles_difer((footballClub1.getScored_goles() - footballClub1.getRecevied_goles()));
                        footballClub2.setGoles_difer((footballClub2.getScored_goles() - footballClub2.getRecevied_goles()));

// Set win or lose count
                        if (club1Score < club2Score) {
                            footballClub1.setDefeats(footballClub1.getDefeats() + lose);
                            footballClub2.setWins(footballClub2.getWins() + win);
//footballClub2.setNo_of_points(footballClub2.getWins() * points);
                        } else if (club1Score > club2Score) {
                            footballClub1.setWins(footballClub1.getWins() + win);
                            footballClub2.setDefeats(footballClub2.getDefeats() + lose);
//footballClub1.setNo_of_points(footballClub1.getWins() * points);
                        } else if (club1Score == club2Score) {
                            footballClub1.setDraws(footballClub1.getDraws() + draw);
                            footballClub2.setDraws(footballClub2.getDraws() + draw);

                        }
// set team points
                        footballClub1.setNo_of_points((footballClub1.getWins() * points) + (footballClub1.getDraws() * halfPoints));
                        footballClub2.setNo_of_points((footballClub2.getWins() * points) + (footballClub2.getDraws() * halfPoints));
                    }
                }
            }
        }
        saveInFile();
//to display team details table
        display();
    }
    @Override
//to write data in matchData file
    public void matchFile() {
        try {
            File myObj = new File("G:\\java_2nd_year\\Sportsclub\\matchData.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(myObj);
                for (Match matchlist : sportsList) {
                    myWriter.write(matchlist.getDate() + "\n");
                    myWriter.write(matchlist.getFirstTeam() + "\n");
                    myWriter.write(matchlist.getSecondTeam() + "\n");
                    myWriter.write(matchlist.getFirstTeamScor() + "\n");
                    myWriter.write(matchlist.getSecondTeamScor() + "\n");
                }
                myWriter.close();
            } else {
                System.out.println("File already exists.");
                FileWriter myWriter = new FileWriter(myObj);
                for (Match matchlist : sportsList) {
                    myWriter.write(matchlist.getDate() + "\n");
                    myWriter.write(matchlist.getFirstTeam() + "\n");
                    myWriter.write(matchlist.getSecondTeam() + "\n");
                    myWriter.write(matchlist.getFirstTeamScor() + "\n");
                    myWriter.write(matchlist.getSecondTeamScor() + "\n");
                }
                myWriter.close();
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    @Override
    public void loadMatchFile() {
        if(PremierLeagueManager.sportsList.size() == 0) {
            try {
                File myObj = new File("G:\\java_2nd_year\\Sportsclub\\matchData.txt");
                BufferedReader red = new BufferedReader(new FileReader(myObj));
                String line = red.readLine();
                while (line != null) {
                    for (int i = 0; i < 5; i++) {
                        if (line == null) {
                            break;
                        }
                        String date = (line);
                        line = red.readLine();
                        String team1 = (String.valueOf(line));
                        line = red.readLine();
                        String team2 = (String.valueOf(line));
                        line = red.readLine();
                        int team1Score = (Integer.valueOf(line));
                        line = red.readLine();
                        int team2Score = (Integer.valueOf(line));
                        line = red.readLine();

                        Match mat = new Match();

                        mat.setDate(date);
                        mat.setFirstTeam(team1);
                        mat.setFirstTeamScor(team1Score);
                        mat.setSecondTeam(team2);
                        mat.setSecondTeamScor(team2Score);
                        sportsList.add(mat);
                    }
                }
                red.close();
            } catch (IOException e) {
//System.out.println("Something Wrong");
            }
        }
    }

    @Override
//Write data in text file - premier
    public void saveInFile() {
        try {
            File myObj = new File("C:\\Users\\Anojan\\Desktop\\CW_Java_04\\premier.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(myObj);
                for (FootballClub footballClub1 : footballClubList) {
                    myWriter.write(footballClub1.getSportsClubName() + "\n");
                    myWriter.write(footballClub1.getLocation() + "\n");
                    myWriter.write(footballClub1.getWins() + "\n");
                    myWriter.write(footballClub1.getDefeats() + "\n");
                    myWriter.write(footballClub1.getDraws() + "\n");
                    myWriter.write(footballClub1.getNo_of_points() + "\n");
                    myWriter.write(footballClub1.getPlayed_matches() + "\n");
                    myWriter.write(footballClub1.getRecevied_goles() + "\n");
                    myWriter.write(footballClub1.getScored_goles() + "\n");
                    myWriter.write(footballClub1.getGoles_difer() + "\n");
                }
                myWriter.close();
            } else {
                System.out.println("File already exists.");
                FileWriter myWriter = new FileWriter(myObj);
                for (FootballClub footballClub1 : footballClubList) {
                    myWriter.write(footballClub1.getSportsClubName() + "\n");
                    myWriter.write(footballClub1.getLocation() + "\n");
                    myWriter.write(footballClub1.getWins() + "\n");
                    myWriter.write(footballClub1.getDefeats() + "\n");
                    myWriter.write(footballClub1.getDraws() + "\n");
                    myWriter.write(footballClub1.getNo_of_points() + "\n");
                    myWriter.write(footballClub1.getPlayed_matches() + "\n");
                    myWriter.write(footballClub1.getRecevied_goles() + "\n");
                    myWriter.write(footballClub1.getScored_goles() + "\n");
                    myWriter.write(footballClub1.getGoles_difer() + "\n");
                }
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    @Override
    public void loadFromFile() {
        try {
            File myFil = new File("C:\\Users\\Anojan\\Desktop\\CW_Java_04\\premier.txt");
            if (myFil.createNewFile()){
                BufferedReader red = new BufferedReader(new FileReader(myFil));
                String line = red.readLine();
                while (line != null) {
                    for (int i = 0; i < 9; i++) {
                        if (line == null){
                            break;
                        }
                        String name = (line);
                        line = red.readLine();
                        String loc = (String.valueOf(line));
                        line = red.readLine();
                        int win  = (Integer.valueOf(line));
                        line = red.readLine();
                        int def  = (Integer.valueOf(line));
                        line = red.readLine();
                        int draw  = (Integer.valueOf(line));
                        line = red.readLine();
                        int point  = (Integer.valueOf(line));
                        line = red.readLine();
                        int match  = (Integer.valueOf(line));
                        line = red.readLine();
                        int rg  = (Integer.valueOf(line));
                        line = red.readLine();
                        int sg  = (Integer.valueOf(line));
                        line = red.readLine();
                        int gf  = (Integer.valueOf(line));
                        line = red.readLine();

                        FootballClub footClub = new FootballClub();
                        footClub.setSportsClubName(name);
                        footClub.setLocation(loc);
                        footClub.setWins(win);
                        footClub.setDefeats(def);
                        footClub.setDraws(draw);
                        footClub.setNo_of_points(point);
                        footClub.setPlayed_matches(match);
                        footClub.setRecevied_goles(rg);
                        footClub.setScored_goles(sg);
                        footClub.setGoles_difer(gf);

                        footballClubList.add(footClub);

                    }
                }
                red.close();
            }else {
                BufferedReader red = new BufferedReader(new FileReader(myFil));
                String line = red.readLine();
                while (line != null) {
                    for (int i = 0; i < 9; i++) {
                        if (line == null){
                            break;
                        }
                        String name = (line);
                        line = red.readLine();
                        String loc = (String.valueOf(line));
                        line = red.readLine();
                        int win  = (Integer.valueOf(line));
                        line = red.readLine();
                        int def  = (Integer.valueOf(line));
                        line = red.readLine();
                        int draw  = (Integer.valueOf(line));
                        line = red.readLine();
                        int point  = (Integer.valueOf(line));
                        line = red.readLine();
                        int match  = (Integer.valueOf(line));
                        line = red.readLine();
                        int rg  = (Integer.valueOf(line));
                        line = red.readLine();
                        int sg  = (Integer.valueOf(line));
                        line = red.readLine();
                        int gf  = (Integer.valueOf(line));
                        line = red.readLine();

                        FootballClub footClub = new FootballClub();
                        footClub.setSportsClubName(name);
                        footClub.setLocation(loc);
                        footClub.setWins(win);
                        footClub.setDefeats(def);
                        footClub.setDraws(draw);
                        footClub.setNo_of_points(point);
                        footClub.setPlayed_matches(match);
                        footClub.setRecevied_goles(rg);
                        footClub.setScored_goles(sg);
                        footClub.setGoles_difer(gf);

                        footballClubList.add(footClub);

                    }
                }
                red.close();
            }
        } catch (IOException e) {
//System.out.println("Something Wrong");
        }

    }

    @Override
    public void exit(){
//Exit from all system
        System.out.println("Exit From Menu");
        System.exit(0);
    }
}