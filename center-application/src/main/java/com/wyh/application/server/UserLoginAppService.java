package com.wyh.application.server;

import com.wyh.application.api.request.UserLoginRequestDTO;
import com.wyh.application.api.response.UserLoginResponseDTO;
import com.wyh.application.repository.LoginUserTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLoginAppService {

    private LoginUserTokenRepository loginUserTokenRepository;

    public UserLoginAppService(LoginUserTokenRepository loginUserTokenRepository) {
        this.loginUserTokenRepository = loginUserTokenRepository;
    }


    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        return loginUserTokenRepository.login(userLoginRequestDTO);
    }
}
