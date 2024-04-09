package com.inkwell.player.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("item-api")
public interface ItemClient {

    @RequestMapping(method = RequestMethod.GET,value = "item/v1/test/{text}", consumes = "application/json")
    String testRequest(@PathVariable("text") String text);
}
