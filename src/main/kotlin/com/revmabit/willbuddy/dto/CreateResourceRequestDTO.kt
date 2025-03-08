package com.revmabit.willbuddy.dto

import com.revmabit.willbuddy.shared.ResourceType


data class CreateResourceRequestDTO(val willRecordId: String, val label:String, val data: Any, val type: ResourceType)
