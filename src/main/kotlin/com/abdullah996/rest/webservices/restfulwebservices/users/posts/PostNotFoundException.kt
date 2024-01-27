package com.abdullah996.rest.webservices.restfulwebservices.users.posts

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(code = HttpStatus.NOT_FOUND)
class PostNotFoundException(override val message:String) : RuntimeException() {

}