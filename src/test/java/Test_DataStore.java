import DTO.*;
import DTO.Tilsyn.*;

import java.util.ArrayList;
import java.util.List;

public class Test_DataStore {

    public List<AbstractTilsyn> InitTilsyn(){
        //Instaciating cathegories of tilsyn
        AbstractTilsyn forældresammarbejde = new Forældresamarbejde();
        forældresammarbejde.setIndsats("forældresammarbejde, Vedligeholdelse af indsats");
        forældresammarbejde.setBegrundelse("forældresammarbejde, begrundelse");
        forældresammarbejde.setAnbefaling("forældresammarbejde, anbefaling");

        System.out.println(forældresammarbejde.toString());

        AbstractTilsyn inklusionOgFællesskab = new InklussionOgFællesskab();
        inklusionOgFællesskab.setIndsats("inklusionOgFællesskab, Vedligeholdelse af indsats");
        inklusionOgFællesskab.setBegrundelse("inklusionOgFællesskab, begrundelse");
        inklusionOgFællesskab.setAnbefaling("inklusionOgFællesskab, anbefaling");

        System.out.println(inklusionOgFællesskab.toString());

        AbstractTilsyn kravOmReflektion = new KravOmReflektion();
        kravOmReflektion.setIndsats("kravOmReflektion, Vedligeholdelse af indsats");
        kravOmReflektion.setBegrundelse("kravOmReflektion, begrundelse");
        kravOmReflektion.setAnbefaling("kravOmReflektion, anbefaling");

        System.out.println(kravOmReflektion.toString());

        AbstractTilsyn sammenhængeOgOvergang = new SammenhængOgOvergange();
        sammenhængeOgOvergang.setIndsats("sammenhængeOgOvergang, Vedligeholdelse af indsats");
        sammenhængeOgOvergang.setBegrundelse("sammenhængeOgOvergang, begrundelse");
        sammenhængeOgOvergang.setAnbefaling("sammenhængeOgOvergang, anbefaling");

        System.out.println(sammenhængeOgOvergang.toString());

        AbstractTilsyn socialeRelationer = new SocialeRelationer();
        socialeRelationer.setIndsats("socialeRelationer, Vedligeholdelse af indsats");
        socialeRelationer.setBegrundelse("socialeRelationer, begrundelse");
        socialeRelationer.setAnbefaling("socialeRelationer, anbefaling");
        System.out.println(socialeRelationer.toString());

        AbstractTilsyn sprogindsatsen = new Sprogindsatsen();
        sprogindsatsen.setIndsats("sprogindsatsen, Vedligeholdelse af indsats");
        sprogindsatsen.setBegrundelse("sprogindsatsen, begrundelse");
        sprogindsatsen.setAnbefaling("sprogindsatsen, anbefaling");
        System.out.println(sprogindsatsen.toString());

        List<AbstractTilsyn> tilsynsKategorier = new ArrayList<>();
        tilsynsKategorier.add(sprogindsatsen);
        tilsynsKategorier.add(socialeRelationer);
        tilsynsKategorier.add(sammenhængeOgOvergang);
        tilsynsKategorier.add(kravOmReflektion);
        tilsynsKategorier.add(inklusionOgFællesskab);
        tilsynsKategorier.add(forældresammarbejde);

        return tilsynsKategorier;
    }

    public Institution createTilsyn(){
        List<AbstractTilsyn> tilsynsKategorier = InitTilsyn();

        //Instaciating Periodisk tilsyn
        PeriodiskeTilsyn tilsyn = new PeriodiskeTilsyn();
        tilsyn.setSprogindsatsen(tilsynsKategorier.get(0));
        tilsyn.setSocialeRelationer(tilsynsKategorier.get(1));
        tilsyn.setSammenhængeOgOvergange(tilsynsKategorier.get(2));
        tilsyn.setKravOmReflektion(tilsynsKategorier.get(3));
        tilsyn.setInklussionOgFællesskab(tilsynsKategorier.get(4));
        tilsyn.setForældresamarbejde(tilsynsKategorier.get(5));

        //Instaciatiang institution object
        Institution institution = new Institution();
        institution.setTilsyn(tilsyn);
        institution.setName("7Springeren");
        institution.setWebpage("http://www.hello.dk");
        institution.setVenteliste(35);


        return institution;
    }


    public List<Institution> getListOfInstitutions(int numberOfInstitutionsInList){

        if(numberOfInstitutionsInList<0){
            return null;
        }

        List<AbstractTilsyn> tilsynsKategorier = InitTilsyn();

        //Instaciating Periodisk tilsyn
        PeriodiskeTilsyn tilsyn = new PeriodiskeTilsyn();
        tilsyn.setSprogindsatsen(tilsynsKategorier.get(0));
        tilsyn.setSocialeRelationer(tilsynsKategorier.get(1));
        tilsyn.setSammenhængeOgOvergange(tilsynsKategorier.get(2));
        tilsyn.setKravOmReflektion(tilsynsKategorier.get(3));
        tilsyn.setInklussionOgFællesskab(tilsynsKategorier.get(4));
        tilsyn.setForældresamarbejde(tilsynsKategorier.get(5));


        List<Institution> listOfInstitutions = new ArrayList<Institution>();

        for(int i = 0; i<numberOfInstitutionsInList;i++){
            Institution institution = new Institution();
            institution.setTilsyn(tilsyn);
            institution.setName(Integer.toString(i));
            institution.setWebpage("http://www."+i+".dk");
            institution.setVenteliste(i);
            listOfInstitutions.add(institution);

        }



        return listOfInstitutions;
    }
}
