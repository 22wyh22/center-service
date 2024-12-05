package com.wyh.domain.service.impl;

import com.wyh.domain.bo.LoginRequestBO;
import com.wyh.domain.bo.LoginResponseBO;
import com.wyh.domain.repository.LoginRepository;
import com.wyh.domain.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginResponseBO login(LoginRequestBO requestBO) {
        return loginRepository.login(requestBO);
    }
}
