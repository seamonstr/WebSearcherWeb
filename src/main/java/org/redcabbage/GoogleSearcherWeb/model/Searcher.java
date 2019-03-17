package org.redcabbage.GoogleSearcherWeb.model;

import java.util.List;

/**
 * Base class for a thing that can run a search and return search results
 */
public interface Searcher {
  List<SearchResult> search(String search);
}
