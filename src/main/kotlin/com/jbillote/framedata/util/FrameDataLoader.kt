package com.jbillote.framedata.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.jbillote.framedata.model.Move
import com.jbillote.framedata.util.CharacterNameMap.CHARACTER_NAME_MAP
import org.springframework.core.io.ClassPathResource

object FrameDataLoader {

    fun loadCharacterMovesFromJSON(game: String, nickname: String) : Map<String, Move> {
        // Throw exception if character nickname provided doesn't have a mapping for name
        CHARACTER_NAME_MAP[nickname] ?: throw Exception()

        val resource = ClassPathResource("data/$game/$nickname.json")

        val characterJSON = resource.file.readText(Charsets.UTF_8)
        val mapper = jacksonObjectMapper()
        mapper.registerKotlinModule()
        val typeRef: TypeReference<Map<String, Move>> = object : TypeReference<Map<String, Move>>() {}

        return mapper.readValue(characterJSON, typeRef)
    }
}
