package com.jgcolab.mymenu.menu;

import com.jgcolab.mymenu.domain.*;
import com.jgcolab.mymenu.repository.MenuRepository;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.jgcolab.mymenu.domain.MealType.*;
import static com.jgcolab.mymenu.domain.Weekday.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
public class MenuRepositoryTest {

    @Mock private MenuRepository menuRepository = mock(MenuRepository.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should Get Menu by Weekday")
    void itShouldGetMenuByWeekday() {
        menuRepository.save(new Menu ("Breakfast", DINNER, SUNDAY));
        assertEquals(SUNDAY, menuRepository.findByWeekday(SUNDAY));
    }
}
