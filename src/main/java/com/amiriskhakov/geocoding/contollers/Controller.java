package com.amiriskhakov.geocoding.contollers;


import com.amiriskhakov.geocoding.dtos.ForwardDTO;
import com.amiriskhakov.geocoding.dtos.ReverseDTO;
import com.amiriskhakov.geocoding.entities.GeocodingEntity;
import com.amiriskhakov.geocoding.exceptions.WrongAddressException;
import com.amiriskhakov.geocoding.exceptions.WrongCoordinatesException;
import com.amiriskhakov.geocoding.http.HttpClient;
import com.amiriskhakov.geocoding.repositories.GeocodingRepository;
import com.amiriskhakov.geocoding.services.GeocodingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Controller {
    @Autowired
    HttpClient httpClient;
    ObjectMapper mapper = new ObjectMapper();
    public static Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    GeocodingService geocodingServiceImpl;

    @Autowired
    GeocodingRepository geocodingRepository;

    @GetMapping("/reverse")
    public ResponseEntity<ReverseDTO> reversing(@RequestParam String lat
            , @RequestParam String lon) throws IOException {

        Optional<GeocodingEntity> entity = geocodingRepository.findByLatAndLon(lat, lon);

        if (entity.isEmpty()) {
            logger.info("address wasnt found in database");
            Response response = httpClient.requestForReverse(lat, lon);
            ResponseBody body = response.body();
            JsonNode node = (mapper.readTree(body.string()));

//
            String fullName = Optional.ofNullable(node.get("display_name"))
                    .orElseThrow(WrongCoordinatesException::new)
                    .asText();
            logger.info("succecfull reversing {}", fullName);
            ReverseDTO dto = new ReverseDTO(fullName);
            geocodingRepository.save(new GeocodingEntity(lat, lon, fullName));
            return new ResponseEntity<>(dto, HttpStatus.OK);

        }
        logger.info("address was found in database");
        return new ResponseEntity<>(new ReverseDTO(entity.get().getAdress()), HttpStatus.OK);


    }

    @GetMapping("/forward")
    public ResponseEntity<ForwardDTO> forwarding(
            @RequestParam String city,
            @RequestParam String street) throws IOException {

        Response response = httpClient.requestForForward(city, street);
        ResponseBody body = response.body();
        JsonNode node = Optional.ofNullable(mapper.readTree(body.string()).get(0))
                .orElseThrow(WrongAddressException::new);


        ForwardDTO dto = new ForwardDTO(node.get("lat").asText()
                , node.get("lon").asText());
        logger.info("succecfull forward {} {}", node.get("lat").asText(), node.get("lon").asText());
        return new ResponseEntity<>(dto, HttpStatus.OK);


    }
}
