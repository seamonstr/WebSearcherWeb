package org.redcabbage.GoogleSearcherWeb.model;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class HardcodedSearcher implements Searcher {
  private List<SearchResult> results = new ArrayList<>();

  {
    try {
      results.add(new SearchResult(
              new URL("https://www.bbcgoodfood.com/howto/guide/health-benefits-bananas"),
              "The health benefits of bananas | BBC Good Food",
              "The banana is a nutritional powerhouse, packed with " +
                      "energy-giving carbohydrate and heart-healthy potassium. " +
                      "Find out more about the UK's ..."));

      results.add(new SearchResult(
              new URL("https://www.medicalnewstoday.com/articles/271157.php"),
              "Bananas: Health benefits, tips, and risks - Medical News Today",
              "Eating them could help lower blood pressure and reduce the risks " +
                      "of cancer and asthma. Today, bananas are grown in at least " +
                      "107 countries and are ranked fourth among the world's food " +
                      "crops in monetary value. ... Listed below are the possible " +
                      "health benefits associated with bananas."));

      results.add(new SearchResult(new URL("https://en.wikipedia.org/wiki/Banana"),
              "Banana - Wikipedia",
              "A banana is an edible fruit – botanically a berry – produced " +
                      "by several kinds of large herbaceous flowering plants in the " +
                      "genus Musa. In some countries ..."));

      results.add(new SearchResult(
              new URL("https://www.healthline.com/nutrition/11-proven-benefits-of-bananas"),
              "11 Evidence-Based Health Benefits of Bananas - Healthline",
              "The banana is one of the most popular health foods on earth. Here " +
                      "are 11 proven ways that bananas can benefit your health."));

      results.add(new SearchResult(
              new URL("https://food.ndtv.com/food-drinks/" +
                      "benefits-of-banana-how-to-include-the-fruit-in-your-daily-diet-1216006"),
              "7 Wonderful Benefits Of Banana: How To Include The Fruit In Your ...",
              "An instant energy booster, banana is one fruit that is commonly available " +
                      "across the globe. In India, it is given much importance where various ..."));

    } catch (MalformedURLException e) {
      throw new Error("Unexpected malformed URL exception", e);
    }
  }

  @Override
  public List<SearchResult> search(String search) {
    List<SearchResult> ret = new ArrayList<>(results.size());
    ret.addAll(results);
    return ret;
  }
}
