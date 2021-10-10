package interview.assessment.controller;

import interview.assessment.entity.Book;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = {"/third-party"})
public class ThirdPartyController {

    @GetMapping
    public ResponseEntity thirdPartyDetail(@RequestParam(name = "id") int id) {

        RestTemplate restTemplate = new RestTemplate();
        Book thirdPartyResponse = restTemplate.getForObject("http://localhost:9090/third-party/book?id={id}", Book.class, id);

        return ResponseEntity.ok().body(thirdPartyResponse);
    }
}
