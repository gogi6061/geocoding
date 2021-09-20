package com.amiriskhakov.geocoding.contollers;

import com.amiriskhakov.geocoding.dtos.ForwardDTO;
import com.amiriskhakov.geocoding.dtos.ReverseDTO;
import com.amiriskhakov.geocoding.exceptions.WrongAddressException;
import com.amiriskhakov.geocoding.exceptions.WrongCoordinatesException;
import com.amiriskhakov.geocoding.http.HttpClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MainController {
    @Autowired
    HttpClient httpClient;
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/reverse")
    public ResponseEntity<ReverseDTO> reversing(@RequestParam String lat
            , @RequestParam String lon) throws IOException {

        Response response = httpClient.requestForReverse(lat, lon);
        ResponseBody body = response.body();
        JsonNode node = (mapper.readTree(body.string()));

//        JsonNode addressNode = node.get("address");
//
//        String country = addressNode.get("country").asText();
//        String city = addressNode.get("city").asText();
        String fullName = Optional.ofNullable(node.get("display_name"))
                .orElseThrow(WrongCoordinatesException::new)
                .asText();
//        String street = addressNode.get("street").asText();
        return new ResponseEntity<>(new ReverseDTO(fullName), HttpStatus.OK);


    }

    @GetMapping("/forward")
    public ResponseEntity<ForwardDTO> forwarding(
            @RequestParam String city,
            @RequestParam String street) throws IOException {
        Response response = httpClient.requestForForward(city, street);
        ResponseBody body = response.body();
        JsonNode node = Optional.ofNullable(mapper.readTree(body.string()).get(0))
                .orElseThrow(WrongAddressException::new);



        return new ResponseEntity<>(new ForwardDTO(node.get("lat").asText()
                , node.get("lon").asText()), HttpStatus.OK);


    }
}
