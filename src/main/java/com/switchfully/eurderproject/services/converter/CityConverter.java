package com.switchfully.eurderproject.services.converter;

import com.switchfully.eurderproject.domain.user.City;
import com.switchfully.eurderproject.services.dtos.CreateCityDto;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {
    public City convertCreateCityDtoInCity(CreateCityDto cityDto) {
        return new City(cityDto.postalCode(), cityDto.city());
    }
}
