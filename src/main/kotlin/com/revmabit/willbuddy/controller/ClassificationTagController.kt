package com.revmabit.willbuddy.controller

import com.revmabit.willbuddy.dto.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/classification-tags")
class ClassificationTagController {

    @GetMapping
    fun filterTags(): ResponseEntity<Unit> = ResponseEntity.ok().build()

    @PostMapping
    fun createTag(@RequestBody data: CreateTagRequestDTO): ResponseEntity<TagDetailsDTO> =
        ResponseEntity.ok().build()

    @GetMapping("/{id}")
    fun fetchDetails(@PathVariable id: String): ResponseEntity<TagDetailsDTO> =
        ResponseEntity.ok().build()

    @PutMapping("/{id}")
    fun modifyDetail(@PathVariable id: String, @RequestBody data: TagDetailsDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()

    @DeleteMapping("/{id}")
    fun removeTag(@PathVariable id: String, @RequestBody data: DeleteRequestDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()

    @PutMapping("/{id}/beneficiary/add")
    fun addBeneficiaryToTag(@PathVariable id: String, @RequestBody data: SingleIDRequestDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()

    @DeleteMapping("/{id}/beneficiary/add")
    fun removeBeneficiaryToTag(@PathVariable id: String, @RequestBody data: SingleIDRequestDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()
}