package com.wyh.application.server;


import com.wyh.application.repository.ESAppRepository;
import com.wyh.common.model.ApiResult;
import org.springframework.stereotype.Service;

@Service
public class ESAppService {

    private ESAppRepository esAppRepository;

    public ESAppService(ESAppRepository esAppRepository) {
        this.esAppRepository = esAppRepository;
    }

    public ApiResult<Object> createIndex(String index) {
        return ApiResult.ok(esAppRepository.createIndex(index));
    }
}
