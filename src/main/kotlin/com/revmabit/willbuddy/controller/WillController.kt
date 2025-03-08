package com.revmabit.willbuddy.controller

import com.revmabit.willbuddy.dto.*
import com.revmabit.willbuddy.entity.WillEntity
import com.revmabit.willbuddy.service.WillServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/wills")
class WillController @Autowired constructor(val willService: WillServiceInterface) {

    @GetMapping
    fun filterWillRecords(@RequestParam page: Int,
                          @RequestParam size: Int ): ResponseEntity<List<WillEntity>> = ResponseEntity.ok(willService.fetchWills(page,size))

    @GetMapping("/summary")
    fun getSummary(): ResponseEntity<Unit> = ResponseEntity.ok().build()

    @PostMapping
    fun createWill(@RequestBody data: CreateWillRequestDTO): ResponseEntity<WillDetailsDTO> =
        ResponseEntity.ok(willService.createWill(data))

    @GetMapping("/{id}")
    fun fetchWillDetail(@PathVariable("id") willRecordId: String): ResponseEntity<WillDetailsDTO> =
        ResponseEntity.ok().build()

    @PutMapping("/{id}")
    fun modifyWill(@PathVariable("id") willRecordId: String, @RequestBody data: WillDetailsDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()

    @DeleteMapping("/{id}")
    fun deleteWill(@PathVariable("id") willRecordId: String): ResponseEntity<Unit> =
        ResponseEntity.ok().build()



    @GetMapping("/{id}/resources")
    fun fetchResources(@PathVariable("id") willRecordId: String): ResponseEntity<WillDetailsDTO> =
        ResponseEntity.ok().build()

    @PostMapping("/{id}/resources")
    fun addResourceToWill(@PathVariable("id") willRecordId: String, @RequestBody data: CreateResourceRequestDTO): ResponseEntity<ResourceDetailsDTO> =
        ResponseEntity.ok().build()

    @PutMapping("/{id}/resources")
    fun updateResource(@PathVariable("id") willRecordId: String, @RequestBody data: ResourceDetailsDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()

    @DeleteMapping("/{id}/resources")
    fun deleteResource(@PathVariable id: String, @RequestBody data: DeleteRequestDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()



    @GetMapping("/{id}/beneficiaries")
    fun fetchBeneficiaries(@PathVariable("id") willRecordId: String): ResponseEntity<ResourceDetailsDTO> =
        ResponseEntity.ok().build()

    @PostMapping("/{id}/beneficiaries/link")
    fun linkBeneficiaryToWill(@PathVariable("id") willRecordId: String, @RequestBody beneficiaryData: SingleIDRequestDTO): ResponseEntity<Any> =
        ResponseEntity.ok().build()

    @PostMapping("/{id}/beneficiaries/unlink")
    fun unLinkBeneficiaryToWill(@PathVariable("id") willRecordId: String, @RequestBody beneficiaryData: SingleIDRequestDTO): ResponseEntity<Any> =
        ResponseEntity.ok().build()
}
