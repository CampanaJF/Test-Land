package com.inkwell.player.service.Impl;

import com.inkwell.player.client.ItemClient;
import com.inkwell.player.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final ItemClient client;

    @Override
    public String test(String text) {
        return client.testRequest(text);
    }
}
