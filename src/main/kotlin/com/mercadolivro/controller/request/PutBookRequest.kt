package com.mercadolivro.controller.request

import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal

data class PutBookRequest(
    var name: String?,
    var price: BigDecimal?
)