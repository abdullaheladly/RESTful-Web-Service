package com.abdullah996.rest.webservices.restfulwebservices.filtering

import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties


//@JsonIgnoreProperties("s")

@JsonFilter("SomeBeanFilter")
data class SomeBean(
    val s: String,
    //@JsonIgnore
    val s1: String,
    val s2: String
)
