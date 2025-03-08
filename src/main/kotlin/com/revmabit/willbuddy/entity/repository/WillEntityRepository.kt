package com.revmabit.willbuddy.entity.repository


import com.revmabit.willbuddy.entity.WillEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WillEntityRepository : CrudRepository<WillEntity, Int> {
    fun findAll(filter: Pageable) : Page<WillEntity>
}