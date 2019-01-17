package com.angualr.StatisticSaver.DTO;

import com.angualr.StatisticSaver.Entity.Pages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagesDTO extends JpaRepository<Pages, Long> {

    Optional<Pages> findById(Long id);
}
