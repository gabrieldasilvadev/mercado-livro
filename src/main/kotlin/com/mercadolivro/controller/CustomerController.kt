package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.extension.toCostumerModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/costumers")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAllCostumers(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAllCostumers(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.toCostumerModel());
    }

    @GetMapping("/{id}")
    fun getCostumer(@PathVariable id: Int): CustomerModel {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun putCostumer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        val customerSaved = customerService.findById(id);
        customerService.putCostumer(customer.toCostumerModel(customerSaved));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCostumer(@PathVariable id: Int) {
        customerService.deleteCostumer(id)
    }
}