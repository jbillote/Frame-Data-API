package com.jbillote.framedata.repository

import com.jbillote.framedata.model.Move
import com.jbillote.framedata.util.CharacterNameMap.CHARACTER_NAME_MAP
import com.jbillote.framedata.util.FrameDataLoader.loadCharacterMovesFromJSON
import org.springframework.stereotype.Repository

@Repository
class MoveRepository {

    fun getMove(game: String, character: String, input: String): Move {
        CHARACTER_NAME_MAP[character] ?: throw Exception()
        val moves = loadCharacterMovesFromJSON(game, character)

        return moves[input] ?: throw Exception()
    }
}
