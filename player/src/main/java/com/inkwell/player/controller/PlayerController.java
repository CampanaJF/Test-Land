package com.inkwell.player.controller;

import com.inkwell.player.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player/v1")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService service;

    @GetMapping("/{text}")
    public ResponseEntity<String> player(@PathVariable("text") String text){

        return new ResponseEntity<>( service.test(text), HttpStatus.OK);
    }
}
