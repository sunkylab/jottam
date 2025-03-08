package com.revmabit.willbuddy.service

import com.revmabit.willbuddy.dto.CreateWillRequestDTO
import com.revmabit.willbuddy.dto.WillDetailsDTO
import com.revmabit.willbuddy.entity.WillEntity
import org.springframework.data.domain.Page

interface WillServiceInterface {
    fun fetchWills(page: Int, size: Int) : List<WillEntity>
    fun createWill(data: CreateWillRequestDTO) : WillDetailsDTO
}