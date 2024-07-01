package com.example.database.controllor

import com.example.database.dto.Person
import com.example.database.dto.UpdateDTO
import com.example.database.repository.PersonRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonApiController(
    val personRepository: PersonRepository
) {

    @GetMapping("/person")
    fun getAll(): List<Person> {
        return personRepository.getAll()
    }

    @PostMapping("/person")
    fun createPerson(
        @RequestBody person: Person
    ) {
        personRepository.createPerson(person.name, person.age)
    }

    @PatchMapping("/person")
    fun updatePerson(
        @RequestBody updateDTO: UpdateDTO
    ) {
        personRepository.updatePerson(updateDTO.ageReplace, updateDTO.ageCompare)
    }

    @DeleteMapping("/person/{id}")
    fun deletePerson(
        @PathVariable id: Int
    ) {
        personRepository.deletePerson(id)
    }

}