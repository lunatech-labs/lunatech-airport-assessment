package com.lunatech.airportassessment.models.reports;

import java.util.List;

public class CommonRunways {

  private List<ReportRow> runways;

  public CommonRunways(List<ReportRow> runways) {
    this.runways = runways;
  }

  public List<ReportRow> getRunways() {
    return runways;
  }
}
