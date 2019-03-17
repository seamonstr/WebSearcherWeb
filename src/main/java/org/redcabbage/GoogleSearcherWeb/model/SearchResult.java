package org.redcabbage.GoogleSearcherWeb.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.net.URL;

@Data
@RequiredArgsConstructor
public class SearchResult {
  private final URL url;
  private final String title;
  private final String description;
}
