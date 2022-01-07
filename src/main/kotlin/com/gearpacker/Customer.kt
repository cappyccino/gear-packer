package com.gearpacker

import javax.persistence.*

@Entity
@Table(name = "customer")
class Customer(
  var name: String,
  @Id @GeneratedValue var id: Long? = null
)
