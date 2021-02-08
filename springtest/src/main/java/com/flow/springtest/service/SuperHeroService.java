package com.flow.springtest.service;

import com.flow.springtest.entity.SuperHero;
import com.flow.springtest.exception.NoSuchThingException;
import com.flow.springtest.repository.SuperHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SuperHeroService {

    private final SuperHeroRepository heroRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public SuperHero createHero(SuperHero hero) {
        SuperHero newHero = heroRepository.save(hero);
        return newHero;
    }

    public List<SuperHero> findAll() {
        List<SuperHero> heroList = heroRepository.findAll();
        return heroList;
    }

    public SuperHero findHeroById(String id) {
        Optional<SuperHero> hero = heroRepository.findById(id);
        if (hero.isEmpty()) {
            throw new NoSuchThingException("No Such Hero!");
        }
        return hero.get();
    }
}
