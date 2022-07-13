package com.mercadolivro.services

import com.mercadolivro.model.CostumerModel
import org.springframework.stereotype.Service

@Service
class CostumerService {

    val costumers = mutableListOf<CostumerModel>()

    fun getAllCostumers(name: String?): List<CostumerModel> {
        name?.let {
            return costumers.filter { it.name.contains(name, true) }
        }
        return costumers;
    }

    fun create(costumer: CostumerModel) {
        val id = if (costumers.isEmpty()) "1" else ((costumers.last().id).toInt() + 1)
        costumers.add(costumer);
    }

    fun getCostumer(id: String): CostumerModel {
        return costumers.first { it.id == id };
    }

    fun putCostumer(costumer: CostumerModel) {
        val costumerFiltred = costumers.first { it.id == costumer.id };
        costumerFiltred.let {
            it.name = costumer.name;
            it.email = costumer.email;
        }
    }

    fun deleteCostumer(id: String) {
        costumers.removeIf { it.id == id };
    }
}