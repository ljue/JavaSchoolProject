package junit;

import com.jvschool.dao.api.PropertyDAO;
import com.jvschool.dao.api.PropertyGroupDAO;
import com.jvschool.model.PropertyEntity;
import com.jvschool.model.PropertyGroupEntity;
import com.jvschool.svc.impl.PropertyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class PropertyServiceTest {

    @Mock
    private PropertyDAO propertyDAO;

    @Mock
    private PropertyGroupDAO propertyGroupDAO;

    @InjectMocks
    private PropertyServiceImpl propertyService;

    private List<PropertyEntity> properties = new ArrayList<>();


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        PropertyEntity propertyEntity1 = new PropertyEntity();
        PropertyEntity propertyEntity2 = new PropertyEntity();
        PropertyEntity propertyEntity3 = new PropertyEntity();
        PropertyEntity propertyEntity4 = new PropertyEntity();
        PropertyGroupEntity group1 = new PropertyGroupEntity();
        PropertyGroupEntity group2 = new PropertyGroupEntity();
        String name1 = "test group1";
        String name2 = "test group2";
        group1.setPropertyGroupName(name1);
        group2.setPropertyGroupName(name2);
        group1.setSolo(true);
        group2.setSolo(false);
        propertyEntity1.setPropertyGroup(group1);
        propertyEntity2.setPropertyGroup(group1);
        propertyEntity3.setPropertyGroup(group2);
        propertyEntity4.setPropertyGroup(group2);
        properties.add(propertyEntity1);
        properties.add(propertyEntity2);
        properties.add(propertyEntity3);
        properties.add(propertyEntity4);
        propertyEntity1.setPropertyName("name1");
        propertyEntity2.setPropertyName("name2");
        propertyEntity3.setPropertyName("name3");
        propertyEntity4.setPropertyName("name4");
        propertyEntity1.setVisible(true);
        propertyEntity2.setVisible(false);
        propertyEntity3.setVisible(true);
        propertyEntity4.setVisible(false);

        when(propertyDAO.getAllProperties()).thenReturn(properties);
        when(propertyGroupDAO.getPropertyGroupByName(name1)).thenReturn(group1);
        when(propertyGroupDAO.getPropertyGroupByName(name2)).thenReturn(group2);
        when(propertyDAO.getPropertyByName("name1")).thenReturn(propertyEntity1);
        when(propertyDAO.getPropertyByName("name2")).thenReturn(propertyEntity2);
        when(propertyDAO.getPropertyByName("name3")).thenReturn(propertyEntity3);
        when(propertyDAO.getPropertyByName("name4")).thenReturn(propertyEntity4);


    }

    @Test
    public void testGetNotSoloProperties() {
        Map<String, List<String>> map = propertyService.getNotSoloProperties();
        boolean b = true;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (propertyGroupDAO.getPropertyGroupByName(entry.getKey()).isSolo()) {
                b = false;
                break;
            }
        }
        Assert.assertTrue(b);
    }

    @Test
    public void testGetSoloProperties() {
        Map<String, List<String>> map = propertyService.getSoloProperties();
        boolean b = true;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!propertyGroupDAO.getPropertyGroupByName(entry.getKey()).isSolo()) {
                b = false;
                break;
            }
        }
        Assert.assertTrue(b);
    }

    @Test
    public void testGetAllVisibleProperties() {
        List<String> properties = propertyService.getAllVisibleProperties();
        boolean b = true;
        for (String name : properties) {
            if (!propertyDAO.getPropertyByName(name).isVisible()) {
                b = false;
                break;
            }
        }
        Assert.assertTrue(b);
    }


}
