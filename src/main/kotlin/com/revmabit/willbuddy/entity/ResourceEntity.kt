package com.revmabit.willbuddy.entity

import com.revmabit.willbuddy.shared.ResourceType
import jakarta.persistence.*

@Entity
open class ResourceEntity: BaseEntity() {

    open lateinit var label: String

    open lateinit var data: String

    @Enumerated(EnumType.STRING)
    open lateinit var type: ResourceType

    @ManyToOne
    open lateinit var will: WillEntity
}