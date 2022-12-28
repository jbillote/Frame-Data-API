package com.jbillote.framedata.repository

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.jbillote.framedata.model.Character
import com.jbillote.framedata.model.Move
import com.jbillote.framedata.util.CharacterNameMap.CHARACTER_NAME_MAP
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Repository

@Repository
class CharacterRepository {

    fun getCharacter(character: String) : Character {
        val characterName = CHARACTER_NAME_MAP[character] ?: throw Exception()

        val resource = ClassPathResource("data/mbtl/$character.json")

        val characterJSON = resource.file.readText(Charsets.UTF_8)
        val mapper = jacksonObjectMapper()
        mapper.registerKotlinModule()
        val typeRef: TypeReference<Map<String, Move>> = object : TypeReference<Map<String, Move>>() {}
        val map = mapper.readValue(characterJSON, typeRef)

        return Character(
            name = characterName,
            moves = map,
            inputs = map.keys.toList()
        )
    }
}
