import Util.IOOperations;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static com.sun.activation.registries.LogSupport.log;

public class TestDataBuilder {

    IOOperations ioOperations = new IOOperations();




    public void retriveDistrictData(){
        try{

            String districts = "13940";

        Document doc = Jsoup.connect("https://pasningogskole.kk.dk/vuggestue-og-dagpleje/bydel?district="+districts+"&field_institution_profile_tid=All").get();
            System.out.println(doc.html());

            ioOperations.writer(districts,doc.html(),"DistrictPages");


        }catch (IOException e){
            e.printStackTrace();
        }
    }






    //Retrives a list with all the district ids.
    private void districtListing(){

    }



    public static void main(String[] args) throws IOException {
        TestDataBuilder testDataBuilder = new TestDataBuilder();
        testDataBuilder.retriveDistrictData();




    }

}
