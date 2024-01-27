package com.abdullah996.rest.webservices.restfulwebservices.filtering

import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class FilteringController {

    @GetMapping("/filtering")
    fun filtering():MappingJacksonValue{
        val someBean=SomeBean("value1","value2","value3")
        val result =applyFilter(someBean, listOf("s1","s2"))
       return result
    }

    @GetMapping("/filtering-list")
    fun filteringList():MappingJacksonValue{
        val list=listOf(
            SomeBean("value1","value2","value3"),
            SomeBean("value1","value2","value3"),
        )
        val result =applyFilter(list, listOf("s"))
        return result
    }

    fun applyFilter(value:Any,list: List<String>):MappingJacksonValue{
        val mappingJacksonValue=MappingJacksonValue(value)
        val filter=SimpleBeanPropertyFilter.filterOutAllExcept(list.toMutableSet())
        val filters=SimpleFilterProvider().addFilter("SomeBeanFilter",filter)
        mappingJacksonValue.filters=filters
        return mappingJacksonValue
    }
}