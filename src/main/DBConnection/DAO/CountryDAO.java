package DAO;

import ShopEntities.CountryEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Людмила on 14.07.2017.
 */
public interface CountryDAO {
    List<CountryEntity> getAllCountries() throws SQLException;
}
