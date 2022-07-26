package test.forum.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class QuoteModel {

    private UUID id;
    @NotNull
    private UUID userId;
    @NotBlank
    @NotNull
    private String text;
    private Integer votesCount;
    private LocalDateTime creationDate;

}
