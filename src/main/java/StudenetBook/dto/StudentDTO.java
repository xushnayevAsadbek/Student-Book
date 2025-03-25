package StudenetBook.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private String id;
    @NotNull(message = "Name required")
    private String name;
    @NotNull (message = "Surname required")
    private String surname;
    @NotNull (message = "Phone required")
    private Integer phone;
    @NotNull(message = "DateofBirh year required")
    private String dateOfBirth;
}
