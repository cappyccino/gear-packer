package com.gearpacker

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController {

  @GetMapping("/")
  fun index(): String {
    return "index"
  }
}
