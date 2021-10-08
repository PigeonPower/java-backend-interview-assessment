package interview.assessment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = {"/third-party"})
public class ThirdPartyController {

    @GetMapping
    public ResponseEntity thirdPartyDetail() {

        RestTemplate restTemplate = new RestTemplate();
        String thirdPartyResponse = restTemplate.getForObject("http://localhost:9090/response", String.class);

        return ResponseEntity.ok().body(thirdPartyResponse);
    }
}
