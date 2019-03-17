package org.redcabbage.GoogleSearcherWeb.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@Slf4j
public class HardcodedSearcherTest {
  private HardcodedSearcher searcher;

  @Before
  public void getSearcher() {
    this.searcher = new HardcodedSearcher();
  }

  @Test
  public void testBasicCase() {
    List<SearchResult> results = searcher.search("whatever");
    Assert.assertTrue(results.size() > 0);
    for (SearchResult result : results) {
      assertNotNull("URL not populated", result.getUrl());
      assertThat("Title not populated", result.getTitle(),
              not(isEmptyOrNullString()));
      assertThat("Description not populated",
              result.getDescription(), not(isEmptyOrNullString()));
    }
  }

  @Test
  public void testHardcodingIsNonMutable() {
    List<SearchResult> results = searcher.search("boo");
    int resultCount = results.size();
    results.remove(1);
    assertEquals(resultCount - 1, results.size());
    log.debug("Hardcoded search result count = " + resultCount);
    results = searcher.search("boo");
    assertEquals("Removing an item from returned list should have had no effect",
            resultCount, results.size());
  }
}