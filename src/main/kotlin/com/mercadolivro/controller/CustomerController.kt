package com.mercadolivro.controller

import com.mercadolivro.extension.toCostumerModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.*
import com.mercadolivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/costumers")
class CustomerController(
    val costumerService: CustomerService
) {

    @GetMapping
    fun getAllCostumers(@RequestParam name: String?): List<CustomerModel> {
        return costumerService.getAllCostumers(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        costumerService.create(customer.toCostumerModel());
    }

    @GetMapping("/{id}")
    fun getCostumer(@PathVariable id: Int, @RequestBody customer: GetCustomerRequest): CustomerModel {
        return costumerService.getCostumer(customer.toCostumerModel(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun putCostumer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        costumerService.putCostumer(customer.toCostumerModel(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCostumer(@PathVariable id: Int) {
        costumerService.deleteCostumer(id)
    }
}