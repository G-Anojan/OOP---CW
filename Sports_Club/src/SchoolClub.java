public class SchoolClub extends FootballClub{
    private String name;
    private int division;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public SchoolClub(String name, int division) {
        this.name = name;
        this.division = division;
    }

}
