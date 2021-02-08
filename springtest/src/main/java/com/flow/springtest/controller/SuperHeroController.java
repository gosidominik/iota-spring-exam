package com.flow.springtest.controller;

import com.flow.springtest.entity.SuperHero;
import com.flow.springtest.exception.NoSuchThingException;
import com.flow.springtest.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/super-hero")
public class SuperHeroController {

    private final SuperHeroService heroService;

    @Autowired
    public SuperHeroController(SuperHeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping("/create")
    public SuperHero createHero(@RequestBody SuperHero hero) {
       SuperHero newHero = heroService.createHero(hero);
       return newHero;
    }

    @GetMapping("/findAll")
    public List<SuperHero> findAll() {
        List<SuperHero> heroList = heroService.findAll();
        return heroList;
    }

    @GetMapping("/find/{id}")
    public SuperHero findHeroById(@PathVariable("id")String id) {
        try {
            SuperHero hero = heroService.findHeroById(id);
            return hero;
        } catch (NoSuchThingException e) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/change/{id}")
    public SuperHero changeHero(@PathVariable("id")String id) {
        SuperHero changed = findHeroById(id);
        return changed;
    }
}
