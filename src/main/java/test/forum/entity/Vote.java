package test.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "votes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(VoteId.class)
public class Vote {

    @Id
    @NotNull
    private UUID userId;

    @Id
    @NotNull
    private UUID quoteId;

    @Column
    @NotNull
    private Boolean voteLike;

}
