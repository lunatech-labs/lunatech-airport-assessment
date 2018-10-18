package com.lunatech.airportassessment.models.reports;

import java.util.List;

public class TopBottomAirports {

  private final List<ReportRow> top;
  private final List<ReportRow> bottom;

  public TopBottomAirports(List<ReportRow> top, List<ReportRow> bottom) {
    this.top = top;
    this.bottom = bottom;
  }

  public List<ReportRow> getTop() {
    return top;
  }

  public List<ReportRow> getBottom() {
    return bottom;
  }

}
