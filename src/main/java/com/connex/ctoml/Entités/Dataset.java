package com.connex.ctoml.Entités;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dataset implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @CollectionTable(name= "age")
   @ElementCollection

   private Map<Long,Float> age;
    @ElementCollection
    @CollectionTable(name="sex")

   private Map<Long,Float> sex;
    @ElementCollection
    @CollectionTable(name="chest_pain_type")
   private Map<Long,Float> chest_pain_type;
    @CollectionTable(name= "blood_pressure")
   @ElementCollection
   private Map<Long,Float> blood_pressure;
    @CollectionTable(name= "cholesterol")
   @ElementCollection
   private Map<Long,Float> cholesterol;
    @CollectionTable(name="Fasting_blood_sugar")
   @ElementCollection
   private Map<Long,Float> fasting_blood_sugar;
    @ElementCollection
    @CollectionTable(name= "resting_ecg")
   private Map<Long,Float> resting_ecg;
    @CollectionTable(name= "maximum_heart_rate")
   @ElementCollection
   private Map<Long,Float> maximum_heart_rate;
    @CollectionTable@Column(name= "angina")
    @ElementCollection
   private Map<Long,Float> angina;
    @CollectionTable(name= "peak")
   @ElementCollection
   private Map<Long,Float> peak;
    @CollectionTable(name= "slope")
   @ElementCollection
   private Map<Long,Float> slope;
    @CollectionTable(name="colored_vessels")
   @ElementCollection
   private Map<Long,Float> colored_vessels;
    @CollectionTable(name="thal")
   @ElementCollection
   private Map<Long,Float> thal;
    @CollectionTable(name= "class")
   @ElementCollection
    @Column(name="class")
    @MapKeyColumn(name="class_key")
   private Map<Long,Float> classe;
}
