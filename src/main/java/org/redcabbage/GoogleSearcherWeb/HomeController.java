package org.redcabbage.GoogleSearcherWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {
  @GetMapping("/")
  public String home(Model model) {
    return "home";
  }

  @PostMapping("/")
  public String postHome() {
    return "home";
  }
}

