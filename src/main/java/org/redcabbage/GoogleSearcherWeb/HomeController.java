package org.redcabbage.GoogleSearcherWeb;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.redcabbage.GoogleSearcherWeb.model.SearchResult;
import org.redcabbage.GoogleSearcherWeb.model.Searcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Log4j2
public class HomeController {
  private static final String SEARCH_RESULTS = "searchResults";

  private final Searcher searcher;

  @GetMapping()
  public String get(@RequestParam(name = "search", required = false) String search,
                    Model model) {
    // Perform the search, if we need to
    if (search != null) {
      List<SearchResult> searchRes = searcher.search(search);
      log.debug("Search results count: " + searchRes.size());
      model.addAttribute(SEARCH_RESULTS, searchRes);
    }

    return "home";
  }

}

