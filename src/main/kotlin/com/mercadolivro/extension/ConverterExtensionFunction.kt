package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostCostumerRequest
import com.mercadolivro.controller.request.PutCostumerRequest
import com.mercadolivro.model.CostumerModel

fun PostCostumerRequest.toCostumerModel(): CostumerModel {
    return CostumerModel(name = this.name, email = this.email)
}

fun PutCostumerRequest.toCostumerModel(id: String): CostumerModel {
    return CostumerModel(id = id, name = this.name, email = this.email)
}
