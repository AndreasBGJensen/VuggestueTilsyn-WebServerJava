package Controller;

import Configuration.Config;

public class ControllerManager {
    private Controller controllerTest;
    private Controller controllerProduction;


    public ControllerManager() {
        this.controllerTest = new ControllerTest();

    }

    public Controller getController(){
        if(Config.getInstance().isTestMode()){
            return controllerTest;
        }
        return controllerProduction;
    }
}
