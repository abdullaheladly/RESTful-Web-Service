package com.abdullah996.rest.webservices.restfulwebservices.users

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UserDaoService {

    companion object {
        private val users: MutableList<User> = mutableListOf()
        private var userCount = 0

        init {
            users.add(User(++userCount, "adam", LocalDate.now().minusYears(30)))
            users.add(User(++userCount, "abdullah", LocalDate.now().minusYears(20)))
            users.add(User(++userCount, "ahmed", LocalDate.now().minusYears(10)))
        }
    }

    fun findAllUsers(): List<User> = users
    fun getUser(id: Int): User? = users.firstOrNull { it.id == id }
    fun deleteById(id: Int) = users.removeIf { it.id == id }
    fun addUser(user: User): Int {
        users.add(user.copy(id = ++userCount))
        return userCount
    }
}