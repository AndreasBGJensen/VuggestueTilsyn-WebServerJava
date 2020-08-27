package DTO;

public class URL_DTO {

    private static URL_DTO url_dto = null;
    private String INITIAL_DISTRICT_URL = "https://pasningogskole.kk.dk/vuggestue-og-dagpleje/bydel?district=&field_institution_profile_tid=All";
    private final String  INITIAL_VUGGESTUE_URL = "https://pasningogskole.kk.dk";

    private URL_DTO(){}

    public static URL_DTO getInstance(){
        if(url_dto==null){
            return new URL_DTO();
        }
        return url_dto;
    }


    public String setDestrictString(String districtCode){

        return "https://pasningogskole.kk.dk/vuggestue-og-dagpleje/bydel?district="+districtCode+"&field_institution_profile_tid=All";
    }

    public String setInstitutionURL(String institutionCode){
        return "https://pasningogskole.kk.dk/institution/"+institutionCode+"/vuggestuen";
    }

    public String getINITIAL_DISTRICT_URL() {
        return INITIAL_DISTRICT_URL;
    }

    public void setINITIAL_DISTRICT_URL(String INITIAL_DISTRICT_URL) {
        this.INITIAL_DISTRICT_URL = INITIAL_DISTRICT_URL;
    }

    public String getINITIAL_VUGGESTUE_URL() {
        return INITIAL_VUGGESTUE_URL;
    }
}
