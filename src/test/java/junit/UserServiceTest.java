package junit;

import com.jvschool.dao.api.UserDAO;
import com.jvschool.model.UserEntity;
import com.jvschool.svc.impl.UserServiceImpl;
import com.jvschool.dto.SessionUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    private String login = "ivan";
    private String password = "ivan";
    private String login1 = "ivan1";
    private String password1 = "ivan1";
    private String email = "aaa@a.a";
    private long id = 5;
    private List<UserEntity> users = new ArrayList<>();
    UserEntity user;

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);


        user = new UserEntity();
        user.setLogin(login);
        when(userDAO.loginUser(login, password)).thenReturn(user);
        when(userDAO.getUserIdByEmail(email)).thenReturn(id);
        when(userDAO.getUserIdByLogin(login)).thenReturn(id);
    }

    @Test
    public void testLoginUser() {
        Assert.assertEquals(login, userService.loginUser(login, password).getLogin());
    }

    @Test
    public void testGetUserIdByEmail() {
        Assert.assertEquals(id, userService.getUserIdByEmail(email));
    }

    @Test
    public void failTestGetUserIdByEmail() {
        Assert.assertEquals(id, userService.getUserIdByEmail(email));
    }

    @Test
    public void testGetUserIdByLogin() {
        Assert.assertEquals(id, userService.getUserIdByLogin(login));
    }

    @Test
    public void failTestGetUserIdByLogin() {
        Assert.assertFalse(id == userService.getUserIdByLogin(login1));
    }

    @Test
    public void testGetTopUsers() {
        when(userDAO.getTopUsers()).thenReturn(users);
        Assert.assertEquals(0, userService.getTopUsers().size());
    }

    @Test
    public void testGetAllUsers() {
        when(userDAO.getAllUsers()).thenReturn(users);
        Assert.assertEquals(0, userService.getAllUsers().size());
    }


}

