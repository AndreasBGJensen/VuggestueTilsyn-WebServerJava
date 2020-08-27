package Controller;

import Configuration.Config;
import DAO.IDatabase;
import DAO.MongoDAO;

public class ControllerManager {
    private IDatabase database = new MongoDAO();
    private Controller controllerTest;
    private Controller controllerProduction;


    public ControllerManager() {
        this.controllerTest = new ControllerTest();
        this.controllerProduction = new ControllerProduction(database);

    }

    public Controller getController(){
        if(Config.getInstance().isTestMode()){
            return controllerTest;
        }
        return controllerProduction;
    }
}
