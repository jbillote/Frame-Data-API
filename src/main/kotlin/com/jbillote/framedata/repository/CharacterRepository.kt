package com.jbillote.framedata.repository

import com.jbillote.framedata.model.Character
import com.jbillote.framedata.util.CharacterNameMap.CHARACTER_NAME_MAP
import com.jbillote.framedata.util.FrameDataLoader.loadCharacterMovesFromJSON
import org.springframework.stereotype.Repository

@Repository
class CharacterRepository {

    fun getCharacterNicknames() : List<String> = CHARACTER_NAME_MAP.keys.toList()

    fun getCharacter(game: String, character: String) : Character {
        val characterName = CHARACTER_NAME_MAP[character] ?: throw Exception()
        val moves = loadCharacterMovesFromJSON(game, character)

        return Character(
            name = characterName,
            moves = moves,
            inputs = moves.keys.toList()
        )
    }
}
