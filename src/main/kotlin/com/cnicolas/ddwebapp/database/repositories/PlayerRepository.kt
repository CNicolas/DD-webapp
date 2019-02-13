package com.cnicolas.ddwebapp.database.repositories

import com.cnicolas.ddwebapp.database.entities.Player
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, Long> {
    override fun findAll(): List<Player> = findAll()

}
