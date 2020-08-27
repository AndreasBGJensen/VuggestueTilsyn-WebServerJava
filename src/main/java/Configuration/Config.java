package Configuration;

public class Config {

    private static Config config = null;
    private static boolean testMode;

    private Config(){

    }

    public static Config getInstance(){
        if(config==null){
            return new Config();
        }
        return config;
    }

    public boolean getTestMode() {
        System.out.println(testMode);
        return testMode;
    }

    public void setTestMode(boolean newtestMode) {

        testMode = newtestMode;
    }




}
