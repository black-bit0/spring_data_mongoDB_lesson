package amazon.amazon_tech_task.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 5, max = 25, message = "Username must be greater than 5 and leas than 25")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}