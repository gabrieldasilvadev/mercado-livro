package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.extension.toCostumerModel
import com.mercadolivro.model.CostumerModel
import com.mercadolivro.services.CostumerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("costumers")
class CostumerController(
    val costumerService: CostumerService
) {

    @GetMapping
    fun getAllCostumers(@RequestParam name: String?): List<CostumerModel> {
        return costumerService.getAllCostumers(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody costumer: PostCostumerRequest) {
        costumerService.create(costumer.toCostumerModel());
    }

    @GetMapping("/{id}")
    fun getCostumer(@PathVariable id: String): CostumerModel {
        return costumerService.getCostumer(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun putCostumer(@PathVariable id: String, @RequestBody costumer: PutCostumerRequest) {
        costumerService.putCostumer(costumer.toCostumerModel(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCostumer(@PathVariable id: String) {
        costumerService.deleteCostumer(id);
    }
}