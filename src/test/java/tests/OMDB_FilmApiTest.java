package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@Epic("OMDB API Test Epic")
@Feature("Valid API Features")
public class OMDB_FilmApiTest {

    private final String FILM_ID = "tt1285016";
    private final String API_KEY = "52ec71bf";

    @Test
    @Story("User tries to get title of films with valid film_id and valid apikey.")
    @Description("valid get api request with valid film_id and valid apikey.")
    public void getTitleOfFilm() {
        given().
                when().
                get("http://www.omdbapi.com/?i={FILM_ID}&apikey={API_KEY}", FILM_ID, API_KEY).
                then().
                statusCode(200).
                body("Title", equalTo("The Social Network"));
    }

    @Test
    public void getYearOfFilm() {
        given().
                when().
                get("http://www.omdbapi.com/?i={FILM_ID}&apikey={API_KEY}", FILM_ID, API_KEY).
                then().
                statusCode(200).
                body("Year", equalTo("2010"));
    }

    @Test
    public void getLanguageOfFilm() {
        given().
                when().
                get("http://www.omdbapi.com/?i={FILM_ID}&apikey={API_KEY}", FILM_ID, API_KEY).
                then().
                statusCode(200).
                body("Language", equalTo("English, French"));
    }

    @Test
    public void getFilmInExistence() {
        given().
                when().
                get("http://www.omdbapi.com/?ii={FILM_ID}&apikey={API_KEY}", FILM_ID, API_KEY).
                then().
                statusCode(200).
                body("Error", equalTo("Incorrect IMDb ID."));
    }
}