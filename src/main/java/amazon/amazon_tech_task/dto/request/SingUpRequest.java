package amazon.amazon_tech_task.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SingUpRequest {
    @NotBlank(message = "Username cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,16}$", message = "Invalid username format")
    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 25, message = "Username must be greater than 5 and leas than 25")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 25, message = "Password must be greater than 5 and leas than 25")
    private String password;
}
