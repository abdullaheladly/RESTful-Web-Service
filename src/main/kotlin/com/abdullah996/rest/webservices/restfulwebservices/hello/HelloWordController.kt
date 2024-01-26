package com.abdullah996.rest.webservices.restfulwebservices.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloWordController {


    @GetMapping("/hello-word")
    fun helloWorld():String{
        return "Hello Word"
    }

    @GetMapping("/hello-word-bean")
    fun helloWorldBean():HelloWordBean{
        return HelloWordBean("hello-word-bean")
    }

    @GetMapping("/hello-word-bean/path-variable/{name}")
    fun helloWorldBeanPathVariable(@PathVariable name:String):HelloWordBean{
        return HelloWordBean("hello $name")
    }

}