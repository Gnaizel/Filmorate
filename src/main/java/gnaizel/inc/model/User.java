package gnaizel.inc.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "email")
public class User {
    int id;
    String email;
    String login;
    String name;
    LocalDate birthday;
}
