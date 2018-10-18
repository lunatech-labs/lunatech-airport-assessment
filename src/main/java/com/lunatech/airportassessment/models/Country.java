package com.lunatech.airportassessment.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country implements java.io.Serializable {

  @Id
  private Long id;

  @NaturalId
  private String code;
  private String name;
  private String continent;
  private String wikipedia_link;
  private String keywords;

  @OneToMany(targetEntity = Airport.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "iso_country", referencedColumnName = "code")
  private List<Airport> airports;

  public Country() {}

  public Country(Long id, String code, String name) {
    this.id = id;
    this.code = code;
    this.name = name;
  }

  public Country(Long id, String code, String name, String continent, String wikipedia_link, String keywords) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.continent = continent;
    this.wikipedia_link = wikipedia_link;
    this.keywords = keywords;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getWikipedia_link() {
    return wikipedia_link;
  }

  public void setWikipedia_link(String wikipedia_link) {
    this.wikipedia_link = wikipedia_link;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public List<Airport> getAirports() {
    return airports;
  }

  public void setAirports(List<Airport> airports) {
    this.airports = airports;
  }

  @Override
  public String toString() {
    return "Country{" +
        "id=" + id +
        ", code='" + code + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
