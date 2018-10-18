package com.lunatech.airportassessment.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "runways")
public class Runways {

  @Id
  private Integer id;
  private Integer airport_ref;
  private String airport_ident;
  private Integer length_ft;
  private Integer width_ft;
  private String surface;
  private Boolean lighted;
  private Boolean closed;
  private String le_ident;
  private Double le_latitude_deg;
  private Double le_longitude_deg;
  private Integer le_elevation_ft;
  private Double le_heading_degT;
  private Integer le_displaced_threshold_ft;
  private String he_ident;
  private Double he_latitude_deg;
  private Double he_longitude_deg;
  private Integer he_elevation_ft;
  private Double he_heading_degT;
  private Integer he_displaced_threshold_ft;

  public Runways() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAirport_ref() {
    return airport_ref;
  }

  public void setAirport_ref(Integer airport_ref) {
    this.airport_ref = airport_ref;
  }

  public String getAirport_ident() {
    return airport_ident;
  }

  public void setAirport_ident(String airport_ident) {
    this.airport_ident = airport_ident;
  }

  public Integer getLength_ft() {
    return length_ft;
  }

  public void setLength_ft(Integer length_ft) {
    this.length_ft = length_ft;
  }

  public Integer getWidth_ft() {
    return width_ft;
  }

  public void setWidth_ft(Integer width_ft) {
    this.width_ft = width_ft;
  }

  public String getSurface() {
    return surface;
  }

  public void setSurface(String surface) {
    this.surface = surface;
  }

  public Boolean getLighted() {
    return lighted;
  }

  public void setLighted(Boolean lighted) {
    this.lighted = lighted;
  }

  public Boolean getClosed() {
    return closed;
  }

  public void setClosed(Boolean closed) {
    this.closed = closed;
  }

  public String getLe_ident() {
    return le_ident;
  }

  public void setLe_ident(String le_ident) {
    this.le_ident = le_ident;
  }

  public Double getLe_latitude_deg() {
    return le_latitude_deg;
  }

  public void setLe_latitude_deg(Double le_latitude_deg) {
    this.le_latitude_deg = le_latitude_deg;
  }

  public Double getLe_longitude_deg() {
    return le_longitude_deg;
  }

  public void setLe_longitude_deg(Double le_longitude_deg) {
    this.le_longitude_deg = le_longitude_deg;
  }

  public Integer getLe_elevation_ft() {
    return le_elevation_ft;
  }

  public void setLe_elevation_ft(Integer le_elevation_ft) {
    this.le_elevation_ft = le_elevation_ft;
  }

  public Double getLe_heading_degT() {
    return le_heading_degT;
  }

  public void setLe_heading_degT(Double le_heading_degT) {
    this.le_heading_degT = le_heading_degT;
  }

  public Integer getLe_displaced_threshold_ft() {
    return le_displaced_threshold_ft;
  }

  public void setLe_displaced_threshold_ft(Integer le_displaced_threshold_ft) {
    this.le_displaced_threshold_ft = le_displaced_threshold_ft;
  }

  public String getHe_ident() {
    return he_ident;
  }

  public void setHe_ident(String he_ident) {
    this.he_ident = he_ident;
  }

  public Double getHe_latitude_deg() {
    return he_latitude_deg;
  }

  public void setHe_latitude_deg(Double he_latitude_deg) {
    this.he_latitude_deg = he_latitude_deg;
  }

  public Double getHe_longitude_deg() {
    return he_longitude_deg;
  }

  public void setHe_longitude_deg(Double he_longitude_deg) {
    this.he_longitude_deg = he_longitude_deg;
  }

  public Integer getHe_elevation_ft() {
    return he_elevation_ft;
  }

  public void setHe_elevation_ft(Integer he_elevation_ft) {
    this.he_elevation_ft = he_elevation_ft;
  }

  public Double getHe_heading_degT() {
    return he_heading_degT;
  }

  public void setHe_heading_degT(Double he_heading_degT) {
    this.he_heading_degT = he_heading_degT;
  }

  public Integer getHe_displaced_threshold_ft() {
    return he_displaced_threshold_ft;
  }

  public void setHe_displaced_threshold_ft(Integer he_displaced_threshold_ft) {
    this.he_displaced_threshold_ft = he_displaced_threshold_ft;
  }
}
