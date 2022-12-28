package com.jbillote.framedata.controller

import com.jbillote.framedata.model.Character
import com.jbillote.framedata.repository.CharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class CharacterController {

    @Autowired
    lateinit var characterRepository: CharacterRepository

    @QueryMapping
    fun getCharacterNicknames() : List<String> = characterRepository.getCharacterNicknames()

    @QueryMapping
    fun getCharacter(@Argument character: String) : Character = characterRepository.getCharacter("mbtl", character)
}
