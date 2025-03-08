package com.revmabit.willbuddy.dto

import com.revmabit.willbuddy.shared.ResourceType


data class ResourceDetailsDTO(val id: String, val label:String, val data: Any, val type: ResourceType, val willRecordId: String,
                              val dateCreated: String,
                              val lastModifiedDate: String)
