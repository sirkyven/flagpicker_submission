package com.venkateshgangisetti.FlagPicker;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

public class FlagServiceRepositoryTest {
    private FlagServiceRepository flagServiceRepository;
    @Before
    public void setUp() {
        flagServiceRepository = new FlagServiceRepository();
    }


    @Test
    public void findByCountry() {
        Country usa = new Country("USA", "🇺🇸");
        assertEquals(flagServiceRepository.findByCountry("USA"), Optional.of(usa));
    }

    @Test
    public void findByContinent() {
        Continent continent = new Continent();
        continent.setContinent("Africa");
        continent.setCountries(Arrays.asList( new Country("Nigeria", "🇳🇬"),
                new Country("Ethiopia", "🇪🇹"),
                new Country("Egypt", "🇪🇬"),
                new Country("DR Congo", "🇨🇩"),
                new Country("South Africa", "🇿🇦")
        ));

        assertEquals(flagServiceRepository.findByContinent("Africa"), Optional.of(continent.getCountries()));
        //testing case ignore
        assertEquals(flagServiceRepository.findByContinent("africa"), Optional.of(continent.getCountries()));

    }
}