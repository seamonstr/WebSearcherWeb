package org.redcabbage.WebSearcherWeb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redcabbage.WebSearcherWeb.model.HardcodedSearcher;
import org.redcabbage.WebSearcherWeb.model.Searcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.any;   
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HomeControllerTest {
  @Autowired
  private MockMvc mockMvc;

  /*
  Use this one to return test values
   */
  private Searcher hardcodedSearcher = new HardcodedSearcher();

  @MockBean
  /*
  Mock searcher used to verify calls are as we expect
   */
  private Searcher searcher = null;

  @Test
  public void testGetWithBasicSearch() throws Exception {
    when(searcher.search("bob")).then((i) -> hardcodedSearcher.search("bob"));
    mockMvc.perform(get("/?search=bob"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            // The page content should include all items returned by the searcher; check for the
            // title of the first item.
            .andExpect(content().string(
                    containsString(hardcodedSearcher.search("whatever").get(0).getTitle())
            ));
    verify(searcher, times(1).description("Should search just once")).search("bob");
  }

  @Test
  public void testWithEmptyString() throws Exception {
    rootPageNoSearch("/?search=");
  }

  @Test
  public void testNoParamGetToRoot() throws Exception {
    rootPageNoSearch("/");
  }

  private void rootPageNoSearch(String path) throws Exception {
    mockMvc.perform(get(path))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(content().string(
                    not(containsString("Search results:"))
            ));
    verify(searcher, never().description("If no param is specified, controller shouldn't search.")).search(any(String.class));
  }
}



