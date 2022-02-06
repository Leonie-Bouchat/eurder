package com.switchfully.eurderproject.services.dtos;

public record CreateAddressDto (String streetName, int streetNumber, CreateCityDto createCityDto){
    @Override
    public CreateCityDto createCityDto() {
        return createCityDto;
    }

}
