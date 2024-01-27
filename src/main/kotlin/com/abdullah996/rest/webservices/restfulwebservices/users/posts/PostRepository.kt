package com.abdullah996.rest.webservices.restfulwebservices.users.posts

import com.abdullah996.rest.webservices.restfulwebservices.users.User
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository:JpaRepository<Post,Int> {

    fun findByUser(user: User):List<Post>

}