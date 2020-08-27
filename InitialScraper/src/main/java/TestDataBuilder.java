import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static com.sun.activation.registries.LogSupport.log;

public class TestDataBuilder {

    private final String INITIAL_DISTRICT_URL = "https://pasningogskole.kk.dk/vuggestue-og-dagpleje/bydel?district=&field_institution_profile_tid=All";


    private HashMap<String,String> currentDistrictCount() throws IOException {
        Document doc = Jsoup.connect(INITIAL_DISTRICT_URL).get();

        Elements elements = doc.getElementsByClass("form-item form-type-select form-item-district");
        Element element =  elements.first().getElementsByTag("select").first();

        HashMap<String,String> districtList = new HashMap<>();

        for(Element i : element.children()){
            System.out.println(i.text());
            System.out.println(i.getElementsByAttribute("value").attr("value"));
            districtList.put(i.text(),i.attr("value"));
        }



        return districtList;

    }


    public void retriveDistrictData(){
        try{

            String districts = "13940";

        Document doc = Jsoup.connect("https://pasningogskole.kk.dk/vuggestue-og-dagpleje/bydel?district="+districts+"&field_institution_profile_tid=All").get();
            System.out.println(doc.html());

            writer(districts,doc.html());


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void writer(String filename,String content) throws IOException {

        String pathFile = "C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\DistrictPages\\"+filename+".txt";

        FileWriter myWriter = new FileWriter(pathFile);
        myWriter.write(content);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }


    //Retrives a list with all the district ids.
    private void districtListing(){

    }



    public static void main(String[] args) throws IOException {
        TestDataBuilder testDataBuilder = new TestDataBuilder();

       String[] districte =  testDataBuilder.currentDistrictCount();

       for (int i = 0; i<districte.length;i++){
           System.out.println(districte[i]);
       }
    }

}
