package rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("giraffes")
public class TestService {

        List<String> giraffes = Arrays.asList("Melman", "Elmer");
        @GET
        public List<String> getGiraffes(){
            System.out.println("sadkalsjdklasjdjklaslkdj");
            return giraffes;
        }
}
