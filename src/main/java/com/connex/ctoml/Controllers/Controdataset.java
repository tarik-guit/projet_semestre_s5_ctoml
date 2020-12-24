package com.connex.ctoml.Controllers;

import com.connex.ctoml.Entités.Dataset;
import com.connex.ctoml.Repositories.Repodataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Map;

@RestController
@CrossOrigin(origins ="*")
public class Controdataset  {

    @Autowired
    private Repodataset repd;
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/dataset")
    public Dataset creerdataset(@RequestBody Dataset d) {

        return  repd.save(d);
    }

    @GetMapping("/dataset/{id}")
    public Dataset recupererdataset(@PathVariable Long id) {

        return  repd.findById(id).get();
    }


    @GetMapping("/recuperer_dataset")
    public String recupererdataset() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
         return  restTemplate.exchange("http://localhost:5000/mlearn/getdata", HttpMethod.GET,entity,String.class).getBody();

    }

}
