import Util.IOOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_IOOperations {

    @Test
    public void Test_readFileContent(){
        String path = "C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\DistrictPages\\13940.txt";

        IOOperations utilFileOperations = new IOOperations();

        String inputHtml = utilFileOperations.readFileContent(path);

        assertFalse(inputHtml.isEmpty());

    }
}
