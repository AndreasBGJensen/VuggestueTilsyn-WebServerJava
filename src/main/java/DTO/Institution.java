package DTO;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

@Entity("institution")
public class Institution extends Object {
    @Id
    String name;
    String homepage;
    int venteliste;
    String adress;
    String openingHours;
    int pladser;
    String tilsynslink;
    PeriodiskeTilsyn periodiskTilsyn;

    public Institution() {
    }

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

    public String getTilsynslink() {
        return tilsynslink;
    }

    public void setTilsynslink(String tilsynslink) {
        this.tilsynslink = tilsynslink;
    }

    public int getPladser() {
        return pladser;
    }

    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}
