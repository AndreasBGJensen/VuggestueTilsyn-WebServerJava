package DTO;


import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

import java.util.HashMap;
import java.util.List;

@Entity("district")
public class DistrictDTO {
    @Id
    int district_id;
    String districtName;
    HashMap<String,String> districtInstitutions;

    public void addDistrictInstitution(String institutionname, String institutionInitWeb){
        districtInstitutions.put(institutionname,institutionInitWeb);
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        if(!district_id.equals("")) {
            this.district_id = Integer.parseInt(district_id);
        }else {
            this.district_id = 0;
        }
    }

    public HashMap<String,String> getDistrictInstitutions() {
        return districtInstitutions;
    }

    public void setDistrictInstitutions(HashMap<String,String> districtInstitutions) {
        this.districtInstitutions = districtInstitutions;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}
