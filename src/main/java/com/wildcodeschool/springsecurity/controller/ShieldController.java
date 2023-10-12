package com.wildcodeschool.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShieldController {

    @GetMapping ("/")
    @ResponseBody
    public String home() {
        return "Welcome to the Shield";
    }

    @GetMapping ("/avengers/assemble")
    @ResponseBody
    public String avengersAssemble() {
        return "Avengers Assemble";
    }

    @GetMapping ("/secrets-bases")
    @ResponseBody
    public String secretBases() {
        return "Wild Code School Base : Lyon, Paris, Bordeaux, Lille, Nantes, Toulouse";
    }

}
