package com.wyh.application.api;

import com.wyh.application.session.SessionCache;
import com.wyh.common.model.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {


    private final SessionCache sessionCache;

    public SessionController(SessionCache sessionCache) {
        this.sessionCache = sessionCache;
    }

    @PostMapping
    public ApiResult<Object> getSession(){
        return ApiResult.ok(sessionCache.getSession());
    }
}
