package com.angualr.StatisticSaver.DTO;

import com.angualr.StatisticSaver.Entity.UserPagesRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPagesRealtionDTO extends JpaRepository<UserPagesRelation, Long> {
}
