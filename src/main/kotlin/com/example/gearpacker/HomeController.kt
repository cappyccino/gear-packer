package com.example.gearpacker

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
  @GetMapping("/")
  fun index(): String {
    return "index"
  }
}
