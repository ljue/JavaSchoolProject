package junit;

import com.jvschool.dao.api.PayWayDAO;
import com.jvschool.model.PayWayEntity;
import com.jvschool.svc.Impl.PayWayServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public class PayWayTest {

    @Mock
    private PayWayDAO payWayDAO;
    @InjectMocks
    private PayWayServiceImpl payWayService;

    private static final String name = "test pay way";

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        PayWayEntity payWayEntity = new PayWayEntity();
        payWayEntity.setPayWayName(name);
        List<PayWayEntity> payWayEntities = new ArrayList<>();
        payWayEntities.add(payWayEntity);
        payWayEntities.add(payWayEntity);

        when(payWayDAO.getPayWayByName(name)).thenReturn(payWayEntity);
        when(payWayDAO.getAllPayWays()).thenReturn(payWayEntities);
    }

    @Test
    public void getPayWayByNameTest() {
        Assert.assertEquals(name, payWayService.getPayWayByName(name).getPayWayName());
    }

    @Test
    public void getAllPayWaysTest(){
        Assert.assertEquals(2, payWayService.getAllPayWays().size());
    }



}
