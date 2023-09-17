package com.digel.interviewjari.data.response

data class CardListResponse(
    val count: Int,
    val `data`: List<Data>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
) {
    data class Data(
        val abilities: List<Ability>?,
        val artist: String,
        val attacks: List<Attack>,
        val cardmarket: Cardmarket,
        val convertedRetreatCost: Int?,
        val evolvesFrom: String?,
        val evolvesTo: List<String>?,
        val flavorText: String?,
        val hp: String,
        val id: String,
        val images: Images,
        val legalities: Legalities,
        val level: String?,
        val name: String,
        val nationalPokedexNumbers: List<Int>,
        val number: String,
        val rarity: String?,
        val regulationMark: String?,
        val resistances: List<Resistance>?,
        val retreatCost: List<String>?,
        val rules: List<String>?,
        val `set`: Set,
        val subtypes: List<String>,
        val supertype: String,
        val tcgplayer: Tcgplayer,
        val types: List<String>,
        val weaknesses: List<Weaknesse>
    ) {
        data class Ability(
            val name: String,
            val text: String,
            val type: String
        )

        data class Attack(
            val convertedEnergyCost: Int,
            val cost: List<String>,
            val damage: String,
            val name: String,
            val text: String
        )

        data class Cardmarket(
            val prices: Prices,
            val updatedAt: String,
            val url: String
        ) {
            data class Prices(
                val averageSellPrice: Double,
                val avg1: Double,
                val avg30: Double,
                val avg7: Double,
                val germanProLow: Double,
                val lowPrice: Double,
                val lowPriceExPlus: Double,
                val reverseHoloAvg1: Double,
                val reverseHoloAvg30: Double,
                val reverseHoloAvg7: Double,
                val reverseHoloLow: Double,
                val reverseHoloSell: Double,
                val reverseHoloTrend: Double,
                val suggestedPrice: Double,
                val trendPrice: Double
            )
        }

        data class Images(
            val large: String,
            val small: String
        )

        data class Legalities(
            val expanded: String?,
            val unlimited: String
        )

        data class Resistance(
            val type: String,
            val value: String
        )

        data class Set(
            val id: String,
            val images: Images,
            val legalities: Legalities,
            val name: String,
            val printedTotal: Int,
            val ptcgoCode: String?,
            val releaseDate: String,
            val series: String,
            val total: Int,
            val updatedAt: String
        ) {
            data class Images(
                val logo: String,
                val symbol: String
            )

            data class Legalities(
                val expanded: String?,
                val unlimited: String
            )
        }

        data class Tcgplayer(
            val prices: Prices,
            val updatedAt: String,
            val url: String
        ) {
            data class Prices(
                val holofoil: Holofoil?,
                val normal: Normal?,
                val reverseHolofoil: ReverseHolofoil?
            ) {
                data class Holofoil(
                    val directLow: Double?,
                    val high: Double,
                    val low: Double,
                    val market: Double,
                    val mid: Double
                )

                data class Normal(
                    val directLow: Double?,
                    val high: Double,
                    val low: Double,
                    val market: Double,
                    val mid: Double
                )

                data class ReverseHolofoil(
                    val directLow: Double?,
                    val high: Double,
                    val low: Double,
                    val market: Double,
                    val mid: Double
                )
            }
        }

        data class Weaknesse(
            val type: String,
            val value: String
        )
    }
}