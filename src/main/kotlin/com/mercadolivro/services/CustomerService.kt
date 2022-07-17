package com.mercadolivro.services

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    val costumers = mutableListOf<CustomerModel>()

    fun getAllCostumers(name: String?): List<CustomerModel> {
        name?.let {
            return costumers.filter { it.name.contains(name, true)};
        }
        return costumers;
    }

    fun create(customer: CustomerModel) {
        println(customer)
        customerRepository.save(customer);
    }

    fun getCostumer(customer: CustomerModel): CustomerModel {
        return costumers.first { it.id == customer.id };
    }

    fun putCostumer(customer: CustomerModel) {
        val costumerFiltred = costumers.first { it.id == customer.id };
        costumerFiltred.let {
            it.name = customer.name;
            it.email = customer.email;
        }
    }

    fun deleteCostumer(id: Int) {
        costumers.removeIf { it.id == id };
    }
}