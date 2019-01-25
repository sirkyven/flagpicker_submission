package com.venkateshgangisetti.FlagPicker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FlagServiceRepository {
    Logger logger = LoggerFactory.getLogger(FlagServiceRepository.class);
    private List<Continent> continents;

    FlagServiceRepository() {
        ObjectMapper mapper = new ObjectMapper();
        //TODO:refactor and make this a generic method to deserialize json files
        try {
            continents = mapper.readValue(ResourceUtils.getFile("classpath:continents.json")
                    , new TypeReference<List<Continent>>() { });
            logger.debug("All continents have been loaded from json" + continents.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<Continent> getAllFlags() {
        logger.debug("service call returning all flags" + continents.toString());
        return continents;
    }

    Optional<Country> findByCountry(String name) {
        //in case of null we can have a custom exception thrown
        Country desiredCountry = continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
        if (desiredCountry != null) {
            logger.debug("service call returning flag for given country" + desiredCountry.toString());
            return Optional.of(desiredCountry);
        };
        return Optional.empty();
    }

    Optional<List<Country>> findByContinent(String name) {
        Continent desiredContinent = continents.stream()
                .filter(continent -> name.equalsIgnoreCase(continent.getContinent()))
                .findAny()
                .orElse(null);
        if (desiredContinent != null) {
            logger.debug("service call returning flag for given country" + desiredContinent.toString());
            return Optional.of(desiredContinent.getCountries());
        }
        return Optional.empty();
    }

}
