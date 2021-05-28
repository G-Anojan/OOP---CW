  public class Match{
    private String firstTeam;
    private String secondTeam;
    private String date;
    private int firstTeamScor;
    private int secondTeamScor;

      public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public int getFirstTeamScor() {
        return firstTeamScor;
    }

    public void setFirstTeamScor(int firstTeamScor) {
        this.firstTeamScor = firstTeamScor;
    }

    public Match() {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamScor = firstTeamScor;
        this.secondTeamScor = secondTeamScor;
        this.date = date;
    }

    public int getSecondTeamScor() {
        return secondTeamScor;
    }

    public void setSecondTeamScor(int secondTeamScor) {
        this.secondTeamScor = secondTeamScor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
