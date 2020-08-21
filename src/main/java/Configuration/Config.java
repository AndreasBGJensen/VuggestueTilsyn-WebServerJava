package Configuration;

public class Config {

    private static Config config = null;
    private boolean testMode = true;

    private Config(){ }

    public static Config getInstance(){
        if(config==null){
            return new Config();
        }
        return config;
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }




}
