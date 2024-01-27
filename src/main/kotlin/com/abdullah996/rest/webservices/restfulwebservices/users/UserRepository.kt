package com.abdullah996.rest.webservices.restfulwebservices.users

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Int> {
}