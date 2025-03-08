package com.revmabit.willbuddy.dto

import com.revmabit.willbuddy.shared.DeleteType


data class DeleteRequestDTO(val parentId:String, val childId: String, val type: DeleteType)
