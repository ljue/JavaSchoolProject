package junit;

import com.jvschool.dao.UserDAO;
import com.jvschool.entities.UserEntity;
import com.jvschool.svc.Impl.UserServiceImpl;
import com.jvschool.util.Attributes.SessionUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCategory() {

        String login = "ivan";
        String password = "ivan";
        UserEntity user = new UserEntity();
        user.setLogin(login);
        when(userDAO.loginUser(login, password)).thenReturn(user);

        SessionUser sessionUser = userService.loginUser(login, password);

        Assert.assertEquals(login, sessionUser.getLogin());

    }


}

