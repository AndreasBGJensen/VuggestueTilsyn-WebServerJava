package Controller;


import DTO.Institution;

public interface IController {

    String getAllInstitutions();
    void addInstitution(Institution institution);
    void updateInstitutio(Institution institution);
}
