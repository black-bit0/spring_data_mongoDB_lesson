package amazon.amazon_tech_task.service;

import amazon.amazon_tech_task.dto.request.SignInRequest;
import amazon.amazon_tech_task.dto.request.SingUpRequest;
import amazon.amazon_tech_task.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    public JwtAuthenticationResponse signUp(SingUpRequest request);

    public JwtAuthenticationResponse signIn(SignInRequest request);
}
