package com.abdullah996.rest.webservices.restfulwebservices.users.posts

import com.abdullah996.rest.webservices.restfulwebservices.users.User
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Post(
    @Id
    @GeneratedValue
    val id:Int,
    val description: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    val user: User?,
)
