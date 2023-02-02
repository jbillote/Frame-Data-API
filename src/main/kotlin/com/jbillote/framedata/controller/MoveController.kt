package com.jbillote.framedata.controller

import com.jbillote.framedata.model.Move
import com.jbillote.framedata.repository.MoveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class MoveController {

    @Autowired
    lateinit var moveRepository: MoveRepository

    @QueryMapping
    fun getMove(@Argument game: String, @Argument character: String, @Argument input: String) :
            Move = moveRepository.getMove(game, character.lowercase(), input.uppercase())
}
