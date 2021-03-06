package com.cnicolas.ddwebapp.controllers

import com.cnicolas.ddwebapp.database.repositories.PlayerRepository
import com.cnicolas.ddwebapp.database.repositories.findByIdOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.ModelMap
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class PagesController(@Autowired private val playerRepository: PlayerRepository) {
    @GetMapping("/")
    fun home(model: ModelMap): ModelAndView {
        val players = playerRepository.findAll()
        model["players"] = players
        return ModelAndView("home", model)
    }

    @GetMapping("/skills")
    fun skills(model: ModelMap): ModelAndView {
        return ModelAndView("skills", model)
    }

    @GetMapping("/actions")
    fun actions(model: ModelMap): ModelAndView {
        return ModelAndView("actions", model)
    }

    @GetMapping("/player/{playerId}")
    fun player(model: ModelMap, @PathVariable("playerId") playerId: Long): ModelAndView {
        val player = playerRepository.findByIdOrNull(playerId)
        player?.let {
            model["player"] = player
            return ModelAndView("player", model)
        } ?: run {
            return ModelAndView("redirect:/")
        }
    }

    @GetMapping("/player-creation")
    fun playerCreation(model: ModelMap): ModelAndView {
        return ModelAndView("player-creation", model)
    }
}
