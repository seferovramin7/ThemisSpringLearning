package com.assignment.themisspringlearning;


import com.assignment.themisspringlearning.model.UserEntity;
import com.assignment.themisspringlearning.repo.UserRepo;
import com.assignment.themisspringlearning.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindUser_Success() {
        // Setup: create a mock user and define repository behavior
        UserEntity mockUser = new UserEntity("Tofiq", 1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // Execution: call the service method
        UserEntity user = userService.saveUser("Tofiq");

        // Assertion: check that the correct user is returned
        Assertions.assertEquals("Tofiq", user.getName());
    }


    @Test
    public void findUserSuccess() {
        UserEntity mockUser = new UserEntity("Tofiq", 2L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));


        UserEntity foundUser = userService.getUser(2L);


        Assertions.assertEquals(mockUser, foundUser);
    }

}
