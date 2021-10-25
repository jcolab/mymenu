package com.jgcolab.mymenu.menu;

import com.jgcolab.mymenu.domain.*;
import com.jgcolab.mymenu.repository.MenuRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
        menuRepository.save(new Menu ("Breakfast", new MealType("Dinner"), new Weekday("Sunday")));
        assertEquals("SUNDAY", menuRepository.findByWeekday("Sunday"));
    }
}
