package DTO;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

import java.util.HashMap;

@Entity("districts")
public class Districts {
      @Id
    String kommuneNavn = null;
    HashMap<String, String> districts = null;


    public String getKommuneNavn() {
        return kommuneNavn;
    }

    public void setKommuneNavn(String kommuneNavn) {
        this.kommuneNavn = kommuneNavn;
    }

    public HashMap<String, String> getDistricts() {
        return districts;
    }

    public void setDistricts(HashMap<String, String> districts) {
        this.districts = districts;
    }
}
