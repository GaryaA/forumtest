package test.forum.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UserModel {

    private UUID id;
    private String name;
    @NotNull
    private String login;
    private String email;
    private LocalDateTime creationDate;

}
