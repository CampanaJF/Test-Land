package com.inkwell.player.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player/v1")
@AllArgsConstructor
public class PlayerController {

    @GetMapping("/one")
    public ResponseEntity<String> player(){

        return new ResponseEntity<>( "I am player", HttpStatus.OK);
    }
}
