package swiftbball.generalmanager.component;

import static io.restassured.RestAssured.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import io.restassured.RestAssured;
import swiftbball.generalmanager.infrastructure.MongoDbExtension;
import swiftbball.generalmanager.repository.Team;

@ExtendWith(MongoDbExtension.class)
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
