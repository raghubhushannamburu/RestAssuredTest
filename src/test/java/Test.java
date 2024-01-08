
import static io.restassured.RestAssured.given;

public class Test {

    public String URL="https://restcountries.com/v3.1/name/{tail}?fullText=true";
    public String ALL="https://restcountries.com/v3.1/all";

    @org.junit.Test
    public  void getResponseBodyforAll(){
        given().when().get(ALL).then().log()
                .status().equals(200);

        given().when().get(ALL).then().log()
                .body();




    }

    @org.junit.Test
    public void getResponseforPathParam(){
        given().pathParam("tail", "Christmas Island").when().get(URL).then().log()
                .all();
        given().pathParam("tail", "Christmas Island").when().get(URL).then().statusCode(200);

    }


    @org.junit.Test
    public void getResponseforInvalidPathparam(){
        given().pathParam("tail", "ChristmasIsland").when().get(URL).then().statusCode(404);

    }




}
