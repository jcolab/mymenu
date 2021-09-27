package com.jgcolab.mymenu.repository;

import com.jgcolab.mymenu.domain.Menu;
import com.jgcolab.mymenu.domain.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	List<Optional<Menu>> findByWeekday(Weekday weekday);
}
