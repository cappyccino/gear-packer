package com.example.gearpacker

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
  @Autowired
  lateinit var repository: CustomerRepository

  @GetMapping("/demo")
  fun demo(): ResponseEntity<String> {
    createCustomer()
    val count = queryAllCustomers()

    return ok().body("New customer count: $count")
  }

  private fun createCustomer() {
    val newCustomer = Customer("John")
   println("********** Saving new customer...")
    repository.save(newCustomer)
  }

  private fun queryAllCustomers(): Int {
    val allCustomers: Iterable<Customer> = repository.findAll()
    val count = allCustomers.count()
    println("********** Number of customers: $count")
    return count
  }

}
