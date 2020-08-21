package Controller;

import DTO.Institution;

import java.io.*;

public class ControllerTest extends Controller implements IController {


    @Override
    public String getAllInstitutions() {
        System.out.println("TEST-MODE GETTING ALL INSTITUTIONS");
        StringWriter jsonString = new StringWriter();
        File file = new File(
                getClass().getClassLoader().getResource("data.json").getFile()
        );
        if (file == null) {
            return "Missing";
        }

        try {
            try (FileReader reader = new FileReader(file);
                 BufferedReader br = new BufferedReader(reader)) {

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    jsonString.write(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString.toString();
    }

    @Override
    public void addInstitution(Institution institution) {

    }

    @Override
    public void updateInstitutio(Institution institution) {

    }
}
