package com.wyh.application.repository;

import com.wyh.application.api.request.UserLoginRequestDTO;
import com.wyh.application.api.response.UserLoginResponseDTO;

public interface LoginUserTokenRepository {

    boolean checkToken(String userId,String token);

    UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO);
}
