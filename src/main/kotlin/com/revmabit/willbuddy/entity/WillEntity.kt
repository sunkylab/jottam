package com.revmabit.willbuddy.entity

import com.revmabit.willbuddy.shared.WillType
import jakarta.persistence.*

@Entity
open class WillEntity: BaseEntity() {

    open lateinit var name: String

    open lateinit var ownerId: String

    open lateinit var createdBy: String

    @Enumerated(EnumType.STRING)
    open lateinit var type: WillType

}