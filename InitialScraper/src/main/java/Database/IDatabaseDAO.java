package Database;

import java.util.HashMap;

public interface IDatabaseDAO {

    void saveUrl(String url);
    void saveDistrict(String districtHtml);
    HashMap<String, String> getDistricts();
    void saveDistrictHtml();
    String getDistrictHtml();
    String getUrls(String urlName);


}
