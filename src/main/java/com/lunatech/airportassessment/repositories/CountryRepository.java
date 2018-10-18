package com.lunatech.airportassessment.repositories;

import com.lunatech.airportassessment.models.Country;
import com.lunatech.airportassessment.models.reports.ReportRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

  Optional<Country> findByCode(String code);

  Optional<Country> findByName(String name);

  @Query(
      value = "SELECT name FROM countries c WHERE levenshtein(c.name, ?1) < ?2",
      nativeQuery = true)
  List<String> findByFuzzyName(String name, int likeliness);

  @Query(
      value = "SELECT c.name as name, count(*) as count " +
              "FROM countries c INNER JOIN airports a ON c.code = a.iso_country " +
              "GROUP BY c.name ORDER BY count DESC LIMIT ?1",
      nativeQuery = true)
  List<ReportRow> queryTopAirports(int limit);

  @Query(
      value = "SELECT c.name as name, count(*) as count " +
              "FROM countries c INNER JOIN airports a ON c.code = a.iso_country " +
              "GROUP BY c.name ORDER BY count ASC LIMIT ?1",
      nativeQuery = true)
  List<ReportRow> queryBottomAirports(int limit);

  @Query(
      value = "SELECT r.le_ident as name, count(*) as count " +
              "FROM runways r " +
              "GROUP BY r.le_ident ORDER BY count DESC LIMIT ?1",
      nativeQuery = true)
  List<ReportRow> queryCommonRunways(int limit);
}
