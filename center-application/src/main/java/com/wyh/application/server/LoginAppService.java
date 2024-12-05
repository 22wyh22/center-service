package com.wyh.application.server;

import com.wyh.application.api.request.LoginRequestDTO;
import com.wyh.application.api.response.LoginResponseDTO;
import com.wyh.application.assembler.LoginBOAssembler;
import com.wyh.domain.bo.LoginRequestBO;
import com.wyh.domain.bo.LoginResponseBO;
import com.wyh.domain.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginAppService {

    private ILoginService iLoginService;

    public LoginAppService(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }


    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        LoginRequestBO requestBO = LoginBOAssembler.toLoginRequestBO(requestDTO);
        LoginResponseBO bo = iLoginService.login(requestBO);
        return LoginBOAssembler.toLoginResponseDTO(bo);
    }
}
