package com.serviceflow.fizzbuzz.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.serviceflow.fizzbuzz.bl.FizzbuzzService;
import com.serviceflow.fizzbuzz.model.FizzbuzzModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/fizzbuzz")
@CrossOrigin(origins = {"*"}, allowCredentials = "true", maxAge = 4800)
@RestController
public class FizzbuzzController {

    private final FizzbuzzService fizzbuzzService;

    @Autowired
    public FizzbuzzController(FizzbuzzService fizzbuzzService) {
        this.fizzbuzzService = fizzbuzzService;
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<FizzbuzzModel> getFizzBuzz(@RequestBody List<Integer> inputSequence) throws JsonProcessingException {
        return new ResponseEntity<>(this.fizzbuzzService.convertToFizzbuzz(inputSequence), HttpStatus.OK);
    }
}
