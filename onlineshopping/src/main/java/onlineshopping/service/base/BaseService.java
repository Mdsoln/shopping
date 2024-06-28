package onlineshopping.service.base;

import onlineshopping.model.AuthRequest;
import onlineshopping.model.AuthResponse;
import onlineshopping.model.UserDto;
import onlineshopping.model.UserResponse;
import onlineshopping.notification.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BaseService {
    ResponseEntity<AuthResponse> createAccount(UserDto userDto);

    ResponseEntity<AuthResponse> authenticate(AuthRequest request);

    ResponseEntity<AuthResponse> verifyOtp(LoginRequest loginRequest);

    ResponseEntity<AuthResponse> resendOtpCodes(String phoneNumber, String oldOtpCodes);

    ResponseEntity<UserResponse> getUser(String enrollmentID);

    ResponseEntity<String> updateProfile(String enrollmentID, MultipartFile profile) throws IOException;
}

