package DTO;

public class Institution {

    String name;
    String homepage;
    int venteliste;
    PeriodiskeTilsyn periodiskTilsyn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebpage() {
        return homepage;
    }

    public void setWebpage(String webpage) {
        this.homepage = webpage;
    }

    public int getVenteliste() {
        return venteliste;
    }

    public void setVenteliste(int venteliste) {
        this.venteliste = venteliste;
    }

    public PeriodiskeTilsyn getTilsyn() {
        return periodiskTilsyn;
    }

    public void setTilsyn(PeriodiskeTilsyn tilsyn) {
        this.periodiskTilsyn = tilsyn;
    }
}
