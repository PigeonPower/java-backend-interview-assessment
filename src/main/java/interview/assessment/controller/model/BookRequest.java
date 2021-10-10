package interview.assessment.controller.model;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class BookRequest {

    @NotEmpty(message = "Name is Mandatory")
    private String name;

}