package com.revmabit.willbuddy.service.implementation

import com.revmabit.willbuddy.dto.CreateWillRequestDTO
import com.revmabit.willbuddy.dto.WillDetailsDTO
import com.revmabit.willbuddy.entity.WillEntity
import com.revmabit.willbuddy.entity.repository.WillEntityRepository
import com.revmabit.willbuddy.service.WillServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.format.DateTimeFormatter

@Service
class WillService @Autowired constructor(val willRepository: WillEntityRepository) : WillServiceInterface {

    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

    override fun fetchWills(page: Int, size: Int): List<WillEntity> {
        return willRepository.findAll(Pageable.ofSize(size).withPage(page)).content
    }

    override fun createWill(data: CreateWillRequestDTO): WillDetailsDTO {

        val willEntity = WillEntity()
        willEntity.name = data.name
        willEntity.ownerId = data.ownerId
        willEntity.createdBy = data.createdBy
        willEntity.type = data.type
        val savedRecord = willRepository.save(willEntity)



        return WillDetailsDTO(
            id = savedRecord.id.toString(),
            name = savedRecord.name,
            createdBy = data.createdBy,
            type = savedRecord.type,
            ownerId = savedRecord.ownerId,
            dateCreated = savedRecord.createdDate?.format(dateFormatter) ?: "N/A",
            lastModifiedDate = savedRecord.lastModifiedDate?.format(dateFormatter) ?: "N/A"
        )
    }
}