package test.forum.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @Column
    private String name;
    @Column
    private String login;
    @Column
    private String email;
    @Column
    private LocalDateTime creationDate;

    @PrePersist
    public void setDefaultValues() {
        if (creationDate == null) {
            creationDate = LocalDateTime.now();
        }
    }
}
