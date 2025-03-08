package com.revmabit.willbuddy.entity.repository

import com.revmabit.willbuddy.entity.ResourceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceEntityRepository : CrudRepository<ResourceEntity, Int> {

}