package com.venkateshgangisetti.FlagPicker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/flags", produces = "application/json")
@CrossOrigin(origins = "*")
public class FlagPickerController {
    Logger logger = LoggerFactory.getLogger(FlagPickerController.class);

    private FlagServiceRepository flagServiceRepository;
    private MetricService metricService;
    @Autowired
    FlagPickerController(FlagServiceRepository flagServiceRepository, MetricService metricService) {
        this.flagServiceRepository = flagServiceRepository;
        this.metricService = metricService;
    }

    @GetMapping("/country/{name}")
    public ResponseEntity<Country> flagForCountry(@PathVariable String name) {
        Optional<Country> optCountry = flagServiceRepository.findByCountry(name);
        if (optCountry.isPresent()) {
            logger.debug("country found"+optCountry.get().toString());
            return new ResponseEntity<>(optCountry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<Continent>> flagForAllContinents() {
        return new ResponseEntity<>(flagServiceRepository.getAllFlags(), HttpStatus.OK);
    }

    @GetMapping("/continent/{name}")
    public ResponseEntity<List<Country>> flagsForContinent(@PathVariable String name) {
        Optional<List<Country>> optCountry = flagServiceRepository.findByContinent(name);
        if (optCountry.isPresent()) {
            return new ResponseEntity<>(optCountry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO:enable this only admin by changing in security config
    @RequestMapping(value = "/status-metric", method = RequestMethod.GET)
    @ResponseBody
    public Map getStatusMetric() {
        return metricService.getFullMetric();
    }
}
