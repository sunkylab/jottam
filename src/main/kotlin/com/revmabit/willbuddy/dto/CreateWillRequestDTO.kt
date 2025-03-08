package com.revmabit.willbuddy.dto

import com.revmabit.willbuddy.shared.WillType


data class CreateWillRequestDTO(val name:String, val createdBy: String, val type: WillType, val ownerId: String)
