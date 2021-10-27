package com.jgcolab.mymenu.repository;

import com.jgcolab.mymenu.domain.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTypeRepository extends JpaRepository<MealType, Long> {
}
