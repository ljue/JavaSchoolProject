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
    private String email = "aaa@a.a";
    private long id = 5;
    private List<UserEntity> users = new ArrayList<>();

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginUser() {

        UserEntity user = new UserEntity();
        user.setLogin(login);
        when(userDAO.loginUser(login, password)).thenReturn(user);

        SessionUser sessionUser = userService.loginUser(login, password);

        Assert.assertEquals(login, sessionUser.getLogin());

    }

    @Test
    public void testGetUserIdByEmail() {

        when(userDAO.getUserIdByEmail(email)).thenReturn(id);
        Assert.assertEquals(id, userService.getUserIdByEmail(email));
    }

    @Test
    public void testGetUserIdByLogin() {

        when(userDAO.getUserIdByLogin(login)).thenReturn(id);
        Assert.assertEquals(id, userService.getUserIdByLogin(login));
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

