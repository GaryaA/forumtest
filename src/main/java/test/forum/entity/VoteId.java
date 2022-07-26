package test.forum.entity;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class VoteId implements Serializable {
    private UUID userId;
    private UUID quoteId;
}
