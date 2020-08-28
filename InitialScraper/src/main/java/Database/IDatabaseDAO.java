package Database;

import DTO.DistrictDTO;
import DTO.Districts;
import DTO.URL_DTO;

import java.util.HashMap;

public interface IDatabaseDAO {

    void saveDistrictDTO(DistrictDTO districtDTO);
    void saveURL_DTO(URL_DTO url);
    DistrictDTO getDistrictDTO(String name);
    Districts getDistrictsByKommune(String name);
    void saveDistrict(Districts district);
    Districts updateDistricts(Districts districts);
    DistrictDTO updateDistrictDTO(DistrictDTO districtDTO);


}
