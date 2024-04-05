package com.inkwell.item.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/v1")
@AllArgsConstructor
public class ItemController {

    @GetMapping("/one")
    public ResponseEntity<String> item(){

        return new ResponseEntity<>( "Thunderfury blessed blade of the windseeker", HttpStatus.OK);
    }
}
