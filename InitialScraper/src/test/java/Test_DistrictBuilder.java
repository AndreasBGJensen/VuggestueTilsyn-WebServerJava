import DTO.DistrictDTO;
import DTO.URL_DTO;
import Util.IOOperations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.*;

public class Test_DistrictBuilder {
IOOperations ioOperations = new IOOperations();
    /*
   This method uses the same html page as retriveDistrictData
    */
    @Test
    public void retriveInstitutionListFromADistrict(){
        String html = ioOperations.readFileContent("C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\DistrictPages\\13940.txt");
            String baseuRL = URL_DTO.getInstance().getINITIAL_VUGGESTUE_URL();
            Document doc = Jsoup.parse(html);
            Elements elements = doc.getElementsByClass("panel-pane pane-views-row");
            Element element = elements.first().getElementsByClass("pane-content").first();
            Elements info = element.children().select("h2");

        HashMap<String, String> institutionAndUrl = new HashMap<>();

            for(Element i : info){
                String url = baseuRL+i.children().first().attr("href");
                institutionAndUrl.put(i.children().select("a").text(),url);
            }



            assertEquals(50,institutionAndUrl.size());




    }

    @Test
    public void Test_getDistrictIds(){
        String html = ioOperations.readFileContent("C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\DistrictPages\\13940.txt");

        Document doc = Jsoup.parse(html);

        Elements elements = doc.getElementsByClass("form-item form-type-select form-item-district");
        Element element = elements.first().getElementsByTag("select").first();

        HashMap<String, String> districtList = new HashMap<>();

        for (Element i : element.children()) {
            districtList.put(i.text(), i.attr("value"));
        }

        assertEquals(14,districtList.size());

    }

    @Test
    public void Test_build_District(){
        //Creating District List
        String html = ioOperations.readFileContent("C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\DistrictPages\\13940.txt");

        Document doc = Jsoup.parse(html);

        Elements elements = doc.getElementsByClass("form-item form-type-select form-item-district");
        Element element = elements.first().getElementsByTag("select").first();

        HashMap<String, String> districtList = new HashMap<>();

        for (Element i : element.children()) {
            districtList.put(i.text(), i.attr("value"));
        }


        //List for all district objects
        List<DistrictDTO> districtDTOList = new ArrayList<DistrictDTO>();

        // Getting an iterator
        //Creating districtDTO for every district and adding them to a list
        Iterator hmIterator = districtList.entrySet().iterator();
        while (hmIterator.hasNext()) {
            DistrictDTO districtDTO = new DistrictDTO();

            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            districtDTO.setDistrict_id(((String)mapElement.getValue()));
            districtDTO.setDistrictName((String)mapElement.getKey());
            districtDTOList.add(districtDTO);
        }

        assertEquals(districtList.size(),districtDTOList.size());

    }


    @Test
    public void Test_CleaningHashmap(){

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Vælg bydel", "");

        Iterator hmIterator = hashMap.entrySet().iterator();
        while (hmIterator.hasNext()) {
            DistrictDTO districtDTO = new DistrictDTO();

            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            if ("".equals(mapElement.getValue()) || "".equals(mapElement.getKey())) {
                hashMap.remove(mapElement.getKey());
            }
            districtDTO.setDistrict_id(((String) mapElement.getValue()));
            districtDTO.setDistrictName((String) mapElement.getKey());
        }


        assertEquals(0,hashMap.size());
    }
}
