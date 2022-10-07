package swiftbball.generalmanager.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import swiftbball.generalmanager.daos.Team;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamsIT {
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void saveNewTeam_success() {
        Team team = Team.builder().name("twolves").location("MN").build();

        given().when()
        .log().all()
        .body(team)
        .contentType(APPLICATION_JSON_VALUE)
        .post("team")
        .then()
        .log().all()
        .statusCode(HttpStatus.CREATED.value());
    }
}
