package com.globomatics.bike.controllers;


import com.globomatics.bike.models.Bike;
import com.globomatics.bike.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public List<Bike> list()
    {
        return bikeService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike)
    {
        bikeService.create(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id)
    {
        return bikeService.findById(id);
    }

}
