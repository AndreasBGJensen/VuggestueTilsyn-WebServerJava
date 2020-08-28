import DTO.DistrictDTO;
import DTO.Districts;
import DTO.URL_DTO;
import Database.DatabaseDAO;
import Database.IDatabaseDAO;
import Database.MongoConnection;
import Util.IOOperations;
import com.mongodb.WriteResult;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test_DatabaseDAO {
    IOOperations ioOperations = new IOOperations();
    IDatabaseDAO database = new DatabaseDAO();


    @Test
    public void Test_DatabaseConnection(){
        Datastore connection = MongoConnection.getInstance();
        assert(connection.getDatabase().getName()!=null);
    }

    @Test
    public void updateDistrictDTO(){
        DistrictDTO initialDistrictDTO = createDistrictDTO();
        database.saveDistrictDTO(initialDistrictDTO);

        //Updated institution
        HashMap<String, String> institutionList = initialDistrictDTO.getDistrictInstitutions();
        institutionList.put("New Test Institution","www.newTestInstitution.dk");

        initialDistrictDTO.setDistrictInstitutions(institutionList);

        database.updateDistrictDTO(initialDistrictDTO);

        DistrictDTO returnDistrictDTO = database.getDistrictDTO(initialDistrictDTO.getDistrictName());

        assertTrue(true,returnDistrictDTO.getDistrictInstitutions().get("New Test Institution"));

        //CleanUP
        Datastore connection = MongoConnection.getInstance();
        Query query = connection.createQuery(DistrictDTO.class).field("_id").equal(initialDistrictDTO.getDistrict_id());
        WriteResult result = connection.delete(query);

        assertEquals(true,result.wasAcknowledged());




    }

    @Test
    public void saveDistrictDTO(){
        DistrictDTO initialDistrictDTO = createDistrictDTO();
        database.saveDistrictDTO(initialDistrictDTO);

        Datastore connection = MongoConnection.getInstance();
        DistrictDTO returnDistrictDTO = connection.createQuery(DistrictDTO.class).field("district_id").equal(initialDistrictDTO.getDistrict_id()).first();

        assertEquals(initialDistrictDTO.getDistrictName(),returnDistrictDTO.getDistrictName());
        assertEquals(initialDistrictDTO.getDistrict_id(),returnDistrictDTO.getDistrict_id());

        Iterator hmIterator = returnDistrictDTO.getDistrictInstitutions().entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();


            assertEquals(initialDistrictDTO.getDistrictInstitutions().get(mapElement.getKey()),mapElement.getValue());

            }

        //CleanUP
       Query query = connection.createQuery(DistrictDTO.class).field("_id").equal(initialDistrictDTO.getDistrict_id());
        WriteResult result = connection.delete(query);

        assertEquals(true,result.wasAcknowledged());

    }

    @Test
    public void getDistrictDTO(){

    }

    @Test
    public void getAllDistrictsByKommune(){

    }

    @Test
    public void saveDistrict(){
        Districts district = new Districts();
        district.setKommuneNavn("København");



        district.setDistricts(createDistrictIDs());
        database.saveDistrict(district);
        Datastore connection = MongoConnection.getInstance();
        Query query = connection.createQuery(Districts.class).field("_id").equal(district.getKommuneNavn());
        WriteResult result = connection.delete(query);

        assertEquals(true,result.wasAcknowledged());

    }

    private HashMap<String, String> createDistrictIDs(){
//Creating list contaning district Ids and district names
        String html = ioOperations.readFileContent("C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\DistrictPages\\13940.txt");

        Document doc = Jsoup.parse(html);

        Elements elements = doc.getElementsByClass("form-item form-type-select form-item-district");
        Element element = elements.first().getElementsByTag("select").first();

        HashMap<String, String> districtList = new HashMap<>();

        for (Element i : element.children()) {
            districtList.put(i.text(), i.attr("value"));
        }

        return districtList;
    }

    private DistrictDTO createDistrictDTO(){
        DistrictDTO districtDTO = new DistrictDTO();

        districtDTO.setDistrictInstitutions(createTestInstitution());
        districtDTO.setDistrictName("TestName");
        districtDTO.setDistrict_id("9999");

        return districtDTO;


    }


    private HashMap<String, String> createTestInstitution(){
        String html = ioOperations.readFileContent("C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\DistrictPages\\13940.txt");
        String baseuRL = URL_DTO.getInstance().getINITIAL_VUGGESTUE_URL();
        Document doc = Jsoup.parse(html);
        Elements elements = doc.getElementsByClass("panel-pane pane-views-row");
        Element element = elements.first().getElementsByClass("pane-content").first();
        Elements info = element.children().select("h2");

        HashMap<String, String> institutionAndUrl = new HashMap<>();

        for(Element i : info){
            //if(!i.children().select("a").text().equals("0-6 års inst. Nordstjernen")) {
                String url = baseuRL + i.children().first().attr("href");
                institutionAndUrl.put(cleanUpStrig(i.children().select("a").text()), url);
            //}
        }

        return institutionAndUrl;
    }

    private String cleanUpStrig(String stringToCleanUP){
        stringToCleanUP = stringToCleanUP.replace(".","");

        return stringToCleanUP;
    }


}
