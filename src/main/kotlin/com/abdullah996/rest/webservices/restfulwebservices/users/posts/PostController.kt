package com.abdullah996.rest.webservices.restfulwebservices.users.posts

import ch.qos.logback.classic.Logger
import com.abdullah996.rest.webservices.restfulwebservices.users.UserNotFoundException
import com.abdullah996.rest.webservices.restfulwebservices.users.UserRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@Validated
@RestController
class PostController constructor(private val postRepository: PostRepository,private val userRepository: UserRepository) {

    @GetMapping("users/{userId}/posts")
    fun getAllPostsForUser(@PathVariable userId:Int):List<Post>{
        val user=userRepository.findById(userId)
        if (user.isEmpty){
            throw UserNotFoundException("id=$userId")
        }
        return postRepository.findByUser(user.get())
    }

    @GetMapping("users/{userId}/posts/{id}")
    fun getPostById(@PathVariable userId:Int,@PathVariable id:Int):Post{
        val user=userRepository.findById(userId)
        if (user.isEmpty){
            throw UserNotFoundException("id=$userId")
        }

        val post= postRepository.findById(id)
        println(post.get().toString())
        if (post.isEmpty){
            throw PostNotFoundException("id=$id")
        }

        return post.get()
    }
    @PostMapping("users/{userId}/posts")
    fun addPostForUser(@PathVariable userId:Int,@Valid @RequestBody post: Post):ResponseEntity<Any>{
        val user=userRepository.findById(userId)
        if (user.isEmpty){
            throw UserNotFoundException("id=$userId")
        }
        val newPost=post.copy(user = user.get())
        postRepository.save(newPost)
        val location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPost.id).toUri()
        return ResponseEntity.created(location).build()
    }
}