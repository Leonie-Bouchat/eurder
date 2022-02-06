package com.switchfully.eurderproject.services.converter;

import com.switchfully.eurderproject.domain.user.Address;
import com.switchfully.eurderproject.domain.user.City;
import com.switchfully.eurderproject.services.dtos.CreateAddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {
    private CityConverter cityConverter;

    @Autowired
    public AddressConverter(CityConverter cityConverter) {
        this.cityConverter = cityConverter;
    }

    public Address convertCreateAddressDtoInAddress(CreateAddressDto addressDto, City city) {
        return new Address(addressDto.streetName(),addressDto.streetNumber(), city);
    }
}
