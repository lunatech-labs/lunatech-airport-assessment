package com.lunatech.airportassessment.controllers;

import com.lunatech.airportassessment.models.reports.CommonRunways;
import com.lunatech.airportassessment.models.reports.TopBottomAirports;
import com.lunatech.airportassessment.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

  @Autowired
  private CountryService service;

  @GetMapping("/country")
  public String country(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    CountryService.SearchCountry searchResult = service.searchCountry(name);
    if (searchResult.getCountry().isPresent()) {
      // Thymeleaf doesn't support Optional out of the box, so we've to get the value if it's there.
      model.addAttribute("country", searchResult.getCountry().get());
    } else {
      model.addAttribute("suggestions", searchResult.getSuggestions());
    }

    return "query";
  }

  @GetMapping("/reports")
  public String reports(Model model) {
    TopBottomAirports searchResult = service.reportTopBottomAirports();
    CommonRunways commonRunways = service.reportCommonRunways();

    model.addAttribute("reportTopBottom", searchResult);
    model.addAttribute("reportRunways", commonRunways);

    return "reports";
  }
}
