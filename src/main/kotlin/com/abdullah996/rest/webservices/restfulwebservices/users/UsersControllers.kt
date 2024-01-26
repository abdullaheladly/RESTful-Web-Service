package com.abdullah996.rest.webservices.restfulwebservices.users

import jakarta.servlet.Servlet
import jakarta.validation.Valid
import org.springframework.boot.origin.TextResourceOrigin.Location
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
class UsersControllers constructor(private val userDaoService: UserDaoService) {


    @GetMapping("/users")
    fun retrieveAllUsers(): List<User> {
        return userDaoService.findAllUsers()
    }

    @GetMapping("/users/{id}")
    fun retrieveUser(@PathVariable id: Int): User? {
        val user = userDaoService.getUser(id) ?: throw UserNotFoundException("id:$id")
        return user
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int) {
        userDaoService.deleteById(id)
    }

    @PostMapping("/users")
    fun retrieveAllUsers(@Valid @RequestBody user: User,bindingResult: BindingResult): ResponseEntity<Any> {

        val id = userDaoService.addUser(user)
        val location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()
        return ResponseEntity.created(location).build()
    }
}