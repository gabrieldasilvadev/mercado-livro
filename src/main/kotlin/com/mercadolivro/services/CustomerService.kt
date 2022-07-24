package com.mercadolivro.services

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAllCostumers(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it);
        }
        return customerRepository.findAll().toList();
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer);
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow();
    }

    fun putCostumer(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception();
        }
        customerRepository.save(customer)
    }

    fun deleteCostumer(id: Int) {
        val customer = findById(id);
        customer.status = CustomerStatus.INATIVO;
        customerRepository.save(customer);
    }
}