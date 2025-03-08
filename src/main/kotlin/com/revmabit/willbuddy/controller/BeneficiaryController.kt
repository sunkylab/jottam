package com.revmabit.willbuddy.controller

import com.revmabit.willbuddy.dto.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/beneficiaries")
class BeneficiaryController {

    @GetMapping
    fun filterBeneficiaries(): ResponseEntity<Unit> = ResponseEntity.ok().build()

    @PostMapping
    fun createBeneficiary(@RequestBody data: CreateBeneficiaryRequestDTO): ResponseEntity<BeneficiaryDetailsDTO> =
        ResponseEntity.ok().build()

    @GetMapping("/{id}")
    fun fetchDetails(@PathVariable id: String): ResponseEntity<BeneficiaryDetailsDTO> =
        ResponseEntity.ok().build()

    @PutMapping("/{id}")
    fun modifyDetail(@PathVariable id: String, @RequestBody data: BeneficiaryDetailsDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()

    @DeleteMapping("/{id}")
    fun removeBeneficiary(@PathVariable id: String, @RequestBody data: DeleteRequestDTO): ResponseEntity<Unit> =
        ResponseEntity.ok().build()
}