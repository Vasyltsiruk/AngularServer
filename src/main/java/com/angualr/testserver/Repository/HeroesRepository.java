package com.angualr.testserver.Repository;

import com.angualr.testserver.Entity.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroesRepository extends JpaRepository<Heroes, Long> {

    List<Heroes> findAll();

    Heroes findHeroesById(Long Id);

    List<Heroes> findHeroesByName(String name);

    void deleteById(Long Id);


}
