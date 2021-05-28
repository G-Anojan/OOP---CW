public class FootballClub extends SportsClub{
    private int wins;
    private int draws;
    private int defeats;
    private int recevied_goles;
    private int scored_goles;
    private int no_of_points;
    private int played_matches;
    private int goles_difer;


    public FootballClub() {

    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getRecevied_goles() {
        return recevied_goles;
    }

    public int getScored_goles() {
        return scored_goles;
    }


    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public void setRecevied_goles(int recevied_goles) {
        this.recevied_goles = recevied_goles;
    }

    public void setScored_goles(int scored_goles) {
        this.scored_goles = scored_goles;
    }

    public void setNo_of_points(int no_of_points) {
        this.no_of_points = no_of_points;
    }

    public void setPlayed_matches(int played_matches) {
        this.played_matches = played_matches;
    }

    public int getNo_of_points() {
        return no_of_points;
    }

    public int getPlayed_matches() {
        return played_matches;
    }



    public int getGoles_difer() {
        return goles_difer;
    }

    public void setGoles_difer(int goles_difer) {
        this.goles_difer = goles_difer;
    }

    public FootballClub(String name, String location, int wins, int draws, int defeats, int recevied_goles, int scored_goles, int no_of_points, int played_matches, int goles_difer) {
        super(name, location);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.recevied_goles = recevied_goles;
        this.scored_goles = scored_goles;
        this.no_of_points = no_of_points;
        this.played_matches = played_matches;
        this.goles_difer = goles_difer;
    }
}
