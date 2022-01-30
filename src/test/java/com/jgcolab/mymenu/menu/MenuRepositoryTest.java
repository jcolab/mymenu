package com.jgcolab.mymenu.menu;

import com.jgcolab.mymenu.domain.*;
import com.jgcolab.mymenu.repository.MenuRepository;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
public class MenuRepositoryTest {

    @Mock private MenuRepository menuRepository = mock(MenuRepository.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //TODO Unit tests
    @Test
    @DisplayName("Create a menu")
    void itShouldCreateAnMenu(){
        Menu menu = new Menu("Test", new MealType("Dinner"), new Weekday("Monday"));
        System.out.println(menu.getId());
        assertEquals(1, menu.getId());
    }
}
