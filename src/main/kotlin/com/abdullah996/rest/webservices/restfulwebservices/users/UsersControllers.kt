package com.abdullah996.rest.webservices.restfulwebservices.users

import jakarta.servlet.Servlet
import jakarta.validation.Valid
import org.springframework.boot.origin.TextResourceOrigin.Location
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


@RestController
@Validated
class UsersControllers constructor(private val userRepository: UserRepository) {


    @GetMapping("/users")
    fun retrieveAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("/users/{id}")
    fun retrieveUser(@PathVariable id: Int): EntityModel<User?> {
        val user = userRepository.findById(id)
        if (user.isEmpty){
            throw UserNotFoundException("id=$id")
        }

        val entityModel=EntityModel.of(user.get())
        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsersControllers::class.java).retrieveAllUsers()).withRel("all-users"))
        return entityModel
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int) {
        userRepository.deleteById(id)
    }

    @PostMapping("/users")
    fun retrieveAllUsers(@Valid @RequestBody user: User,bindingResult: BindingResult): ResponseEntity<Any> {

        val id = userRepository.save(user)
        val location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()
        return ResponseEntity.created(location).build()
    }
}