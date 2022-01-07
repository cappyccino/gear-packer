package com.gearpacker

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {
  fun findByName(name: String): Customer?
}
