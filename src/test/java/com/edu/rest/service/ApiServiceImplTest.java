package com.edu.rest.service;

import com.edu.rest.model.UserData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiServiceImplTest {

    @Autowired
    private ApiService apiService;

    @Before
    public void setUp() {

    }

    @Test
    public void receiveUserData() {
        UserData userData = apiService.receiveUserData(3);
        assertNotNull(userData);
        assertEquals(userData.getData().size(), 4);
    }
}