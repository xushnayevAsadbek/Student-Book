package StudenetBook.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    private String id;
    @NotBlank(message = "Name required")
    @Size(min = 2, max = 255, message = "Name length must be beetwen 2 and 255")
    private String title;
    @NotBlank(message = "Author required")
    @Size(min = 2 , max = 255, message ="Authot length must be beetwen 2 and 255")
   private String author;
    @NotNull(message = "Publisher year required")
    private LocalDate publisher;
}
