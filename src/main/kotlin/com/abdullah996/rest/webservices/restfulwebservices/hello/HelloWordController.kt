package com.abdullah996.rest.webservices.restfulwebservices.hello

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class HelloWordController constructor(private val messageSource: MessageSource) {



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

    @GetMapping("/hello-word-internationalize")
    fun helloWorldInternationalize():String{
        val locale:Locale=LocaleContextHolder.getLocale()
        return messageSource.getMessage("good.morning.message", null,"",locale)?:""
        //return "Hello Word v2"
    }

}