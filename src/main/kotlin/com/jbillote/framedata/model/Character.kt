package com.jbillote.framedata.model

data class Character (
    val name:  String,
    val moves: Map<String, Move>,
    val inputs: List<String>
)
