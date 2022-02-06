package com.switchfully.eurderproject.repositories;

import com.switchfully.eurderproject.domain.user.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultCityRepository extends CrudRepository<City, String> {

}
