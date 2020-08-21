package DTO.Tilsyn;

public abstract class AbstractTilsyn {
    String indsats;
    String begrundelse;
    String anbefaling;

    public String getIndsats() {
        return indsats;
    }

    public void setIndsats(String indsats) {
        this.indsats = indsats;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    public void setBegrundelse(String begrundelse) {
        this.begrundelse = begrundelse;
    }

    public String getAnbefaling() {
        return anbefaling;
    }

    public void setAnbefaling(String anbefaling) {
        this.anbefaling = anbefaling;
    }

    @Override
    public String toString() {
        return  this.getClass().getName()+"{"+
                "indsats='" + indsats + '\'' +
                ", begrundelse='" + begrundelse + '\'' +
                ", anbefaling='" + anbefaling + '\'' +
                '}';
    }

}
