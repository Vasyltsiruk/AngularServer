package com.angualr.testserver.Controller;

import com.angualr.testserver.Entity.Heroes;
import com.angualr.testserver.Service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/heroes")
public class HeroesController {

    @Autowired
    private HeroesService heroesService;
    @GetMapping("")
    public ResponseEntity<List<Heroes>> getAllHeroes(){
        return heroesService.findAll().map(heroes -> new ResponseEntity<>(heroes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Heroes> getOneHeroById(@PathVariable("id") Long id){
        return heroesService.findHeroById(id).map(heroes -> new ResponseEntity<>(heroes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/list/{name}")
    private ResponseEntity<List<Heroes>> searchHeroes(@PathVariable("name") String name){
        return heroesService.searchHeroesByName(name).map(heroes -> new ResponseEntity<>(heroes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
    @PostMapping("")
    public ResponseEntity<Heroes> addHero(@RequestBody Heroes hero){
        return heroesService.add(hero).map(heroes -> new ResponseEntity<>(heroes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
    @PutMapping("")
    public ResponseEntity<Heroes> updateHero(@RequestBody Heroes hero){
        return heroesService.updateHero(hero).map(heroes -> new ResponseEntity<>(heroes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Heroes> deleteHero(@PathVariable Long id){
        return heroesService.delete(id).map(heroes -> new ResponseEntity<>(heroes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
