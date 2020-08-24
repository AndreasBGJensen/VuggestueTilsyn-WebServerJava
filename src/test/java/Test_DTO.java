import DTO.Tilsyn.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import DTO.*;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class Test_DTO {

    private List<AbstractTilsyn> initPeriodistTilsyn(){
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

    /*
    Testing that abstraction of institution is working proporbly
     */

    @Test
    public void Test_InstitutionInstances(){


        List<AbstractTilsyn> tilsynsKategorier = initPeriodistTilsyn();
        //Testing if each object will get its own string
        for (int i = 1; i<tilsynsKategorier.size();i++){
            assertFalse(tilsynsKategorier.get(i).toString().equals(tilsynsKategorier.get(i-1).toString()));
        };

    }

    /*
    It is preferred that we get a plain Json Object with out ant json arrays, when we map the objects
     */

    @Test
    public void Test_FormatOffJSON() throws JsonProcessingException {

        List<AbstractTilsyn> tilsynsKategorier = initPeriodistTilsyn();

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


        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(institution);

        System.out.println(jsonStr);


    }

}
