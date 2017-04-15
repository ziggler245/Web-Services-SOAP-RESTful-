package wwe;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:WrestleService [/wrestle]<br>
 * USAGE:
 * <pre>
 *        FightRESTful client = new FightRESTful();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Serhii Khaliavin
 */
public class FightRESTful {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTful_SERVER/webresources";

    public FightRESTful() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("wrestle");
    }

    public <T> T insert_p(Class<T> responseType, String name,String ncard, String phone, String surname, int index, String place, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (name != null) {
            resource = resource.queryParam("name", name);
        }
        if (ncard != null) {
            resource = resource.queryParam("ncard", ncard);
        }
        if (phone != null) {
            resource = resource.queryParam("phone", phone);
        }
        if (surname != null) {
            resource = resource.queryParam("surname", surname);
        }
        if (index != 0) {
            resource = resource.queryParam("index", index);
        }
        if (place != null) {
            resource = resource.queryParam("place", place);
        }
        if (email != null) {
            resource = resource.queryParam("email", email);
        }
        resource = resource.path("inser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllCountries(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allCities");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllFightsPpv(Class<T> responseType, String date, String country, String ppv) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (date != null) {
            resource = resource.queryParam("date", date);
        }
        if (country != null) {
            resource = resource.queryParam("country", country);
        }
        if (ppv != null) {
            resource = resource.queryParam("ppv", ppv);
        }
        resource = resource.path("getPpvFight");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllFights(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allFight");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPpv(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allPpv");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllSeats(Class<T> responseType, String ppv) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (ppv != null) {
            resource = resource.queryParam("ppv", ppv);
        }
        resource = resource.path("getAllSeat");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T check(Class<T> responseType, String ncard, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (ncard != null) {
            resource = resource.queryParam("ncard", ncard);
        }
        if (email != null) {
            resource = resource.queryParam("email", email);
        }
        resource = resource.path("getClient");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
