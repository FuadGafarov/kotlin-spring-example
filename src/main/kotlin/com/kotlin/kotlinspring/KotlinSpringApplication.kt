package com.kotlin.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity
import javax.persistence.Id

@SpringBootApplication
class KotlinSpringApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringApplication>(*args)
}

@RestController
class NameController(val service: NameService) {
    @GetMapping
    fun getNames() = service.getNames()
}

@Service
class NameService(val repository: NameRepository) {
    fun getNames() = repository.findAll()
}

interface NameRepository : JpaRepository<Name, Long>

@Entity(name = "NAMES")
data class Name(@Id val id: Long?, val name: String)