package swiftbball.generalmanager.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Document(collection = "Team")
public class Team {

    @Setter(AccessLevel.NONE)
    @Id
    private long id;
    private String name;
    private String location;

}
