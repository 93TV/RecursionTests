public class Persoon {
    private String naam;
    private int leeftijd;
    private Geslacht geslacht;

    public Persoon(String naam, int leeftijd, Geslacht geslacht) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
    }

    public Persoon() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    @Override
    public String toString() {
        return naam + " - " + leeftijd + "jaar - " + geslacht;
    }
}
