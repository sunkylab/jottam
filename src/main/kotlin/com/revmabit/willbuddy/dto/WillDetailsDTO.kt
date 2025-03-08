package com.revmabit.willbuddy.dto

import com.revmabit.willbuddy.shared.WillType


data class WillDetailsDTO(val id: String, val name:String, val createdBy: String, val type: WillType, val ownerId: String,
                          val dateCreated: String,
                          val lastModifiedDate: String)
