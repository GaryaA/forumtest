package test.forum.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "quotes")
@Getter
@Setter
public class QuoteEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column
    @NotBlank
    private String text;
    @Column
    private LocalDateTime creationDate;

    @Formula("(select sum(case when v.vote_like = 1 then 1 else -1 end) from votes v where v.quote_id = id)")
    private int votesCount;

    @PrePersist
    public void setDefaultValues() {
        if (creationDate == null) {
            creationDate = LocalDateTime.now();
        }
    }
}
