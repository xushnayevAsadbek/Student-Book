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
public class StudentDTO {
    private String id;
    @NotBlank(message = "Name required")
    @Size(min = 2 , max = 255 , message = "Name length must be between 2 and 255")
    private String name;
    @NotBlank (message = "Surname required")
    @Size(min = 2 , max = 255 , message = "Surname length must be between 2 and 255")
    private String surname;
    @NotBlank (message = "Phone required")
    @Size(min = 12 , max = 12 , message = "Enter Current phone number")
    private Integer phone;
    @NotNull(message = "DateofBirh year required")
    private String createdDate;
}
