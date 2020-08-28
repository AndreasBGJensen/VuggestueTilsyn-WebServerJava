package Database;

import DTO.DistrictDTO;
import DTO.Districts;
import DTO.URL_DTO;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateResults;

import java.util.HashMap;


public class DatabaseDAO implements IDatabaseDAO {
    Datastore connection = MongoConnection.getInstance();


    @Override
    public void saveDistrictDTO(DistrictDTO districtDTO) {
        connection.save(districtDTO);
    }

    @Override
    public void saveURL_DTO(URL_DTO url) {
        connection.save(url);
    }

    @Override
    public DistrictDTO getDistrictDTO(String name) {

        DistrictDTO result = connection.createQuery(DistrictDTO.class).field("districtName").equal(name).first();

        return result;
    }

    @Override
    public Districts getDistrictsByKommune(String kommuneName) {

        Districts returnList = connection.createQuery(Districts.class).field("kommuneNavn").equal(kommuneName).first();
        return returnList;
    }

    @Override
    public void saveDistrict(Districts district) {
        connection.save(district);
    }

    @Override
    public Districts updateDistricts(Districts districts) {
        Query query = connection.createQuery(Districts.class).field("name").equal(districts.getKommuneNavn());
        UpdateOperations<Districts> operation = connection.createUpdateOperations(Districts.class)
                .set("districts",districts.getDistricts());
        UpdateResults result = connection.update(query,operation);

        if(!result.getUpdatedExisting()){
            return null;
        }
        return districts;
    }

    /*
    Updating the list of institutions in the district.
     */
    @Override
    public DistrictDTO updateDistrictDTO(DistrictDTO districtDTO) {
        Query query = connection.createQuery(DistrictDTO.class).field("district_id").equal(districtDTO.getDistrict_id());
        UpdateOperations<DistrictDTO> operation = connection.createUpdateOperations(DistrictDTO.class)
                .set("districtInstitutions",districtDTO.getDistrictInstitutions());
        UpdateResults result = connection.update(query,operation);

        if(!result.getUpdatedExisting()){
            return null;
        }
        return districtDTO;
    }

}
