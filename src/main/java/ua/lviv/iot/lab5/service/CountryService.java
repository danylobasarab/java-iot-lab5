package ua.lviv.iot.lab5.service;

import ua.lviv.iot.lab5.domain.City;
import ua.lviv.iot.lab5.domain.Country;

import java.util.List;

public interface CountryService extends GeneralService<Country, String> {
    List<City> findCityByCountryId(String nameId);
}
