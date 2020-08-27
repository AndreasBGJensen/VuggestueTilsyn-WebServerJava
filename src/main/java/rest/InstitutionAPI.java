package rest;

import Configuration.Config;
import Controller.Controller;
import Controller.ControllerManager;
import DAO.DatabaseExceptions.DatabaseRetriveContentError;
import DTO.Institution;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("institution")
public class InstitutionAPI {


    ControllerManager manager = new ControllerManager();
    Controller controller = manager.getController();


    @GET
    public List<Institution> getInstitution() throws DatabaseRetriveContentError {

        return (List<Institution>) controller.getAllObjecte();
    }
}
