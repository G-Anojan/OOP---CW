public class SportsClub {
    private String sportsClubName;
    private String location;

    public SportsClub() {

    }

    public String getSportsClubName() {
        return sportsClubName;
    }

    public void setSportsClubName(String sportsClubName) {
        this.sportsClubName = sportsClubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SportsClub(String name, String location) {
        this.sportsClubName = name;
        this.location = location;
    }
}
