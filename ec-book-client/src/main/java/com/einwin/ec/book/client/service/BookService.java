package com.einwin.ec.book.client.service;

import com.einwin.ec.book.api.BookInterface;
import com.einwin.ec.book.api.service.BookRemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = BookInterface.SERVICE_NAME, fallback = BookService.HystrixClientFallback.class)
public interface BookService extends BookRemoteService {

    @Component
    public static class HystrixClientFallback implements BookService{
        private static Logger logger = LoggerFactory.getLogger(HystrixClientFallback.class);
    }

}
