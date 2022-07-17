package com.mercadolivro.extension

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.*

fun PostCustomerRequest.toCostumerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCostumerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun GetCustomerRequest.toCostumerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email);
}
