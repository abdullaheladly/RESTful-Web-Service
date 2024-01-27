package com.abdullah996.rest.webservices.restfulwebservices.versioning

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersioningPersonController {
    // different url
   @GetMapping("/v1/person")
    fun getFirstVersionOfPerson():PersonV1{
        return PersonV1("abdullah nabil")
    }

    @GetMapping("/v2/person")
    fun getSecondVersionOfPerson():PersonV2{
        return PersonV2(Name("abdullah","nabil"))
    }


    // request param
    @GetMapping(path = ["/person"], params = ["version=1"])
    fun getFirstVersionOfPersonRequestParam():PersonV1{
        return PersonV1("abdullah nabil")
    }

    @GetMapping(path = ["/person"], params = ["version=2"])
    fun getSecondVersionOfPersonRequestParam():PersonV2{
        return PersonV2(Name("abdullah","nabil"))
    }

        //headers
    @GetMapping(path = ["/person/header"], headers = ["X-API_VERSION=1"])
    fun getFirstVersionOfPersonRequestHeaders():PersonV1{
        return PersonV1("abdullah nabil")
    }

    @GetMapping(path = ["/person/header"], headers = ["X-API_VERSION=2"])
    fun getSecondVersionOfPersonRequestHeaders():PersonV2{
        return PersonV2(Name("abdullah","nabil"))
    }

    //media type
    @GetMapping(path = ["/person/accept"], produces = ["application/vnd.company.app-v1+json"])
    fun getFirstVersionOfPersonAcceptHeaders():PersonV1{
        return PersonV1("abdullah nabil")
    }
    @GetMapping(path = ["/person/accept"], produces = ["application/vnd.company.app-v2+json"])
    fun getSecondVersionOfPersonAcceptHeaders():PersonV2{
        return PersonV2(Name("abdullah","nabil"))
    }


}