package Util;

import java.io.*;
import java.util.Scanner;

public class IOOperations {


    public String readFileContent(String filePath){
        try {
            String basePath = new File(filePath).getAbsolutePath();

            basePath = basePath.replace("/", "\\");
            basePath = basePath.replace("'\'", "\\");

            StringBuilder stringBuilder = new StringBuilder();

            File myObj = new File(basePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append("\n");
                stringBuilder.append(data);
                            }
            myReader.close();

            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }



    }

    public void writer(String filename,String content, String foldername) throws IOException {

        String pathFile = "C:\\Uddannelse\\Projects\\tilsynmedvuggestuer\\WebServerJava\\InitialScraper\\src\\test\\java\\TestPages\\"+foldername+"\\"+filename+".txt";

        FileWriter myWriter = new FileWriter(pathFile);
        myWriter.write(content);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }


}
