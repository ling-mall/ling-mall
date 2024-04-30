package com.ling.lingcloud.account.service.impl;

import com.ling.lingcloud.account.api.entity.AccountUser;
import com.ling.lingcloud.account.api.vo.AccountUserVO;
import com.ling.lingcloud.account.mapper.AccountUserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 用户服务实现单元测试.
 * Class created on 2024/4/8 by 钟舒艺
 *
 * @author 钟舒艺
 */
@ExtendWith(MockitoExtension.class)
class AccountUserServiceImplTest {
    private final String username = "admin";
    @Mock
    AccountUserMapper accountUserMapper;
    @InjectMocks
    AccountUserServiceImpl accountUserService;
    private AccountUser expectedUser;

    @BeforeEach
    void setUp() {
        expectedUser = new AccountUser();
        expectedUser.setId(1L);
        expectedUser.setUsername(username);
        expectedUser.setPassword("password");
    }


    @Test
    public void testGetUserByUserName() {
        // Arrange
        when(accountUserMapper.selectUserByUserName(username)).thenReturn(expectedUser);

        // Act
        AccountUser actualUser = accountUserService.getUserByUserName(username);

        // Assert
        assertNotNull(actualUser, "User should not be null");
        assertEquals(expectedUser.getId(), actualUser.getId(), "User IDs should match");
        assertEquals(expectedUser.getUsername(), actualUser.getUsername(), "Usernames should match");

        // Verify that the method was called with the correct parameters
        verify(accountUserMapper, times(1)).selectUserByUserName(username);
    }

    @Test
    public void testGetUserByUserName_UserNotFound() {
        // Arrange
        when(accountUserMapper.selectUserByUserName(username)).thenReturn(null);

        // Act
        AccountUser actualUser = accountUserService.getUserByUserName(username);

        // Assert
        assertNull(actualUser, "User should be null when not found");

        // Verify that the method was called with the correct parameters
        verify(accountUserMapper, times(1)).selectUserByUserName(username);
    }


    @Test
    public void getUserByUserIdTest() {
        // Arrange
        when(accountUserMapper.selectById(1L)).thenReturn(expectedUser);

        // Act
        AccountUserVO accountUserVO = accountUserService.getUserByUserId(1L);

        // Assert
        assertNotNull(accountUserVO, "Returned accountUserVO should not be null");
        assertEquals(expectedUser.getId(), accountUserVO.getId(), "User ID should match");
        assertEquals(expectedUser.getEmail(), accountUserVO.getEmail(), "User email should match");

        // Verify that the mapper was called
        verify(accountUserMapper).selectById(1L);
    }
}
