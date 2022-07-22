package com.mercadolivro.extension

import com.mercadolivro.controller.request.*
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCostumerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCostumerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun GetCustomerRequest.toCostumerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email);
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer =  customer
    )
}

fun PutBookRequest.toBookModel(previousValues: BookModel): BookModel {
    return BookModel(
        id = previousValues.id,
        name = this.name ?: previousValues.name,
        price = this.price ?: previousValues.price,
        status = previousValues.status,
        customer = previousValues.customer
    )
}