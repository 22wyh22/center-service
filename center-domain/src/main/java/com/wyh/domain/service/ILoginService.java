package com.wyh.domain.service;

import com.wyh.domain.bo.LoginRequestBO;
import com.wyh.domain.bo.LoginResponseBO;

public interface ILoginService {

    LoginResponseBO login(LoginRequestBO requestBO);
}
