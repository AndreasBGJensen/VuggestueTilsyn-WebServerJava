package Scraper.InitialDataCollector;

import DTO.DistrictDTO;
import DTO.URL_DTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class DistrictBuilder {

    URL_DTO url_dto = URL_DTO.getInstance();

    public List<DistrictDTO> buildDistrict() throws IOException {
        HashMap<String, String> districts = getDistrictIds();

        List<DistrictDTO> districtList = new ArrayList<DistrictDTO>();

        // Getting an iterator
        Iterator hmIterator = districts.entrySet().iterator();
        while (hmIterator.hasNext()) {
            DistrictDTO districtDTO = new DistrictDTO();

            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            districtDTO.setDistrict_id(((String)mapElement.getValue()));
            districtDTO.setDistrictName((String)mapElement.getKey());
            districtList.add(districtDTO);
        }

        //Mapping institutions to districtDTO
        for (DistrictDTO district : districtList){
            district.setDistrictInstitutions(getDistrictInstitutions(Integer.toString(district.getDistrict_id())));
        }

        return districtList;
    }

    /*
    Returns a hashmap with contaning District as key and the district id as value.
     */
    private HashMap<String, String> getDistrictIds() throws IOException {

        Document doc = Jsoup.connect(url_dto.getINITIAL_DISTRICT_URL()).get();

        Elements elements = doc.getElementsByClass("form-item form-type-select form-item-district");
        Element element = elements.first().getElementsByTag("select").first();

        HashMap<String, String> districtList = new HashMap<>();

        for (Element i : element.children()) {
            districtList.put(i.text(), i.attr("value"));
        }

        return cleaningHashMap(districtList);
    }


    /*
    Returns a hashmap with contaning name of institution as key and the initUrl for the institution as value.
     */
    private HashMap<String, String> getDistrictInstitutions(String districtID) throws IOException {
        try {
            String baseuRL = URL_DTO.getInstance().getINITIAL_VUGGESTUE_URL();
            Document doc = Jsoup.connect(url_dto.setDestrictString(districtID)).get();
            Elements elements = doc.getElementsByClass("panel-pane pane-views-row");
            Element element = elements.first().getElementsByClass("pane-content").first();
            Elements info = element.children().select("h2");

            HashMap<String, String> institutionAndUrl = new HashMap<>();

            for (Element i : info) {
                String url = baseuRL + i.children().first().attr("href");
                System.out.println(url);
                institutionAndUrl.put(i.children().select("a").text(), url);
            }
            return institutionAndUrl;
        }catch (NullPointerException e){
            System.out.println(districtID);
        }

        return null;


    }

    private HashMap<String,String> cleaningHashMap(HashMap<String,String> hashMap) {
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

        return hashMap;
    }
/*
    public static void main(String[] args) throws IOException {
        DistrictBuilder builder = new DistrictBuilder();
        builder.buildDistrict();
    }

 */
}
