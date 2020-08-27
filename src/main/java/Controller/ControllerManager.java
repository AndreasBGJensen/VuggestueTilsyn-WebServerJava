package Controller;

import Configuration.Config;
import DAO.IDatabase;
import DAO.MongoDAO;

public class ControllerManager {
private boolean TEST_MODE = false;
    private IDatabase database = new MongoDAO();
    private Controller controllerTest;
    private Controller controllerProduction;


    public ControllerManager() {
        this.controllerTest = new ControllerTest();
        this.controllerProduction = new ControllerProduction(database);
        Config.getInstance().setTestMode(TEST_MODE);



    }

    public Controller getController(){
        if(Config.getInstance().getTestMode()){
            return controllerTest;
        }
        return controllerProduction;
    }
}
