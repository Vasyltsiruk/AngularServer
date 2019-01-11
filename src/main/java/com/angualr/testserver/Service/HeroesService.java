package com.angualr.testserver.Service;

import com.angualr.testserver.Entity.Heroes;
import com.angualr.testserver.Repository.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HeroesService {

    @Autowired
    private HeroesRepository heroesRepository;

    @Transactional(readOnly = true)
    public Optional<List<Heroes>> findAll(){
        Optional <List<Heroes>> heroesList = Optional.ofNullable(heroesRepository.findAll());
        return heroesList;
    }

    @Transactional(readOnly = true)
    public Optional<Heroes> findHeroById(Long id){
        Optional<Heroes> hero = Optional.ofNullable(heroesRepository.findHeroesById(id));
        return hero;
    }

    public Optional<Heroes> add(Heroes hero) {
        if (heroesRepository.findHeroesById(hero.getId())!= null){
            return Optional.empty();
        }
            Optional<Heroes> newHero = Optional.ofNullable(heroesRepository.save(hero));
        return newHero;
    }

    @Transactional
    public Optional<List<Heroes>> searchHeroesByName(String name){
        Optional<List<Heroes>> heroesList = Optional.ofNullable(heroesRepository.findHeroesByName(name));
        return heroesList;
    }

    public Optional<Heroes> updateHero(Heroes hero){
        Heroes existingHero = heroesRepository.findHeroesById(hero.getId());
        if (existingHero != null){
            existingHero.setName(hero.getName());
            heroesRepository.save(existingHero);
        }
        return Optional.ofNullable(existingHero);
    }

    public Optional<Heroes> delete(Long id){
        Heroes existingHero = heroesRepository.findHeroesById(id);
        if (existingHero != null){
            heroesRepository.deleteById(existingHero.getId());
        }
        return Optional.ofNullable(existingHero);
    }
}
