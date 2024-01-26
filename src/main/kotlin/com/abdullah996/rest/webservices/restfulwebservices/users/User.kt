package com.abdullah996.rest.webservices.restfulwebservices.users

import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class User(
    val id:Int,
    @field:Size(min = 2)
    val name:String,
    @field:Past
    val birthDate:LocalDate
)
