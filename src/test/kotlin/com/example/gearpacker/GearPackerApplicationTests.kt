package com.example.gearpacker

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GearPackerApplicationTests {

  @Test
  fun contextLoads() {
    print("FOOOOOOOO")
  }

  @Test
  fun failure() {
    assert(false);
  }
}
