package com.internaltools.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse extends ApiResponse implements Serializable {
    private String accessToken;

    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    private String firstName;

    private String lastName;

    private String userEmailId;

    private String mobileNumber;

    private Long userId;
}
