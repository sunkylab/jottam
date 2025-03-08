package com.revmabit.willbuddy.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null

    @Version
    open var version: Long? = 0

    @CreatedDate
    @Column(nullable = false, updatable = false)
    open var createdDate: LocalDateTime? = LocalDateTime.now()

    @LastModifiedDate
    open var lastModifiedDate: LocalDateTime? = LocalDateTime.now()

    @Column(nullable = true)
    open var deletedOn: LocalDateTime? = null
}
