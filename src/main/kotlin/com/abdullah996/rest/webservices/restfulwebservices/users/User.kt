package com.abdullah996.rest.webservices.restfulwebservices.users

import com.abdullah996.rest.webservices.restfulwebservices.users.posts.Post
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.annotation.Generated
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate


@Entity(name = "user_details")
data class User(
    @Id
    @GeneratedValue
    val id:Int,
    @field:Size(min = 2)
    val name:String,
    @field:Past
    val birthDate:LocalDate,
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    val posts:List<Post> = emptyList()
)
