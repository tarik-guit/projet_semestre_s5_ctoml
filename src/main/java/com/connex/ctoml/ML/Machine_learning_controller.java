package com.connex.ctoml.ML;

import com.connex.ctoml.auth_ml.catchjwt_ml;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Machine_learning_controller {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private catchjwt_ml jwtc;


    @GetMapping("/train")
    public JSONObject train(){
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        this.jwtc.avoirjwt();
        headers.add("Authorization",this.jwtc.getJwt_ml_f());
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:5000/api/train", HttpMethod.GET, entity, JSONObject.class).getBody();


    }

    @PostMapping("/predict")
    public JSONObject predict(@RequestBody Data_prediction data){
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        this.jwtc.avoirjwt();
        headers.add("Authorization",this.jwtc.getJwt_ml_f());
        HttpEntity<Data_prediction> entity = new HttpEntity<Data_prediction>(data,headers);

        return restTemplate.exchange(
                "http://localhost:5000/api/predict", HttpMethod.POST, entity, JSONObject.class).getBody();


    }
}
