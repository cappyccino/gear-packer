package com.example.gearpacker
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Bean
fun dataSource(): DataSource {
  val dataSource = DriverManagerDataSource()
  dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver")
  dataSource.username = System.getenv("spring.datasource.username")
  dataSource.password = System.getenv("spring.datasource.password")
  dataSource.url = System.getenv("spring.datasource.url")
  return dataSource
}
