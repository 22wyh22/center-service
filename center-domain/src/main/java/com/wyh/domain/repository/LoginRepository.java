package com.wyh.domain.repository;

import com.wyh.domain.bo.LoginRequestBO;
import com.wyh.domain.bo.LoginResponseBO;

public interface LoginRepository {

    LoginResponseBO login(LoginRequestBO loginRequestBO);
}
