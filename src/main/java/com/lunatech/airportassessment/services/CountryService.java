package com.lunatech.airportassessment.services;

import com.lunatech.airportassessment.models.Country;
import com.lunatech.airportassessment.models.reports.CommonRunways;
import com.lunatech.airportassessment.models.reports.ReportRow;
import com.lunatech.airportassessment.models.reports.TopBottomAirports;
import com.lunatech.airportassessment.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

  public static final int SEARCH_LIKELINESS = 2;
  public static final int REPORT_TOP_BOTTOM_LIMIT = 10;
  public static final int REPORT_COMMON_LIMIT = 10;

  @Autowired
  private CountryRepository cRepository;

  public Optional<Country> findByCode(String code) {
    return cRepository.findByCode(code);
  }

  public SearchCountry searchCountry(String name) {
    SearchCountry result;
    Optional<Country> countryOpt = cRepository.findByName(name);

    if (countryOpt.isPresent()) {
      result = new SearchCountry(countryOpt);
    } else {
      List<String> suggestions = cRepository.findByFuzzyName(name, SEARCH_LIKELINESS);
      result = new SearchCountry(suggestions);
    }

    return result;
  }

  public TopBottomAirports reportTopBottomAirports() {
    List<ReportRow> top = cRepository.queryTopAirports(REPORT_TOP_BOTTOM_LIMIT);
    List<ReportRow> bottom = cRepository.queryBottomAirports(REPORT_TOP_BOTTOM_LIMIT);

    return new TopBottomAirports(top, bottom);
  }

  public CommonRunways reportCommonRunways() {
    List<ReportRow> comm = cRepository.queryCommonRunways(REPORT_COMMON_LIMIT);

    return new CommonRunways(comm);
  }

  public class SearchCountry {
    private final Optional<Country> country;
    private final List<String> suggestions;

    public SearchCountry(Optional<Country> country) {
      this.country = country;
      this.suggestions = Collections.emptyList();
    }

    public SearchCountry(List<String> suggestions) {
      this.suggestions = suggestions;
      this.country = Optional.empty();
    }

    public Optional<Country> getCountry() {
      return country;
    }

    public List<String> getSuggestions() {
      return suggestions;
    }
  }
}
