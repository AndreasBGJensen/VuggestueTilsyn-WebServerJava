package DTO;

import DTO.Tilsyn.*;

public class PeriodiskeTilsyn {

    AbstractTilsyn inklussionOgFællesskab;
    AbstractTilsyn socialeRelationer;
    AbstractTilsyn sprogindsatsen;
    AbstractTilsyn forældresamarbejde;
    AbstractTilsyn sammenhængeOgOvergange;
    AbstractTilsyn kravOmReflektion;


    public AbstractTilsyn getInklussionOgFællesskab() {
        return inklussionOgFællesskab;
    }

    public void setInklussionOgFællesskab(AbstractTilsyn inklussionOgFællesskab) {
        this.inklussionOgFællesskab = inklussionOgFællesskab;
    }

    public AbstractTilsyn getSocialeRelationer() {
        return socialeRelationer;
    }

    public void setSocialeRelationer(AbstractTilsyn socialeRelationer) {
        this.socialeRelationer = socialeRelationer;
    }

    public AbstractTilsyn getSprogindsatsen() {
        return sprogindsatsen;
    }

    public void setSprogindsatsen(AbstractTilsyn sprogindsatsen) {
        this.sprogindsatsen = sprogindsatsen;
    }

    public AbstractTilsyn getForældresamarbejde() {
        return forældresamarbejde;
    }

    public void setForældresamarbejde(AbstractTilsyn forældresamarbejde) {
        this.forældresamarbejde = forældresamarbejde;
    }

    public AbstractTilsyn getSammenhængeOgOvergange() {
        return sammenhængeOgOvergange;
    }

    public void setSammenhængeOgOvergange(AbstractTilsyn sammenhængeOgOvergange) {
        this.sammenhængeOgOvergange = sammenhængeOgOvergange;
    }

    public AbstractTilsyn getKravOmReflektion() {
        return kravOmReflektion;
    }

    public void setKravOmReflektion(AbstractTilsyn kravOmReflektion) {
        this.kravOmReflektion = kravOmReflektion;
    }


}
