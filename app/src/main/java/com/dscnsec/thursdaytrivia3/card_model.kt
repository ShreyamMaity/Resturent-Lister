package com.dscnsec.thursdaytrivia3



class Card {
    var id: String? = null
    var title: String? = null
    var price: Number? = null
    var image: String? = null
    var specialitis: String? = null
    var rating: Number? = null

    constructor() {}
    constructor(
        id: String?,
        title: String?,
        price: Number?,
        image: String?,
        specialitis: String?,
        rating: Number?,
    ) {
        this.id = id
        this.title = title
        this.price = price
        this.image = image
        this.specialitis = specialitis
        this.rating = rating
    }

    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "title" to title,
            "price" to price,
            "image" to image,
            "specialitis" to specialitis,
            "rating" to rating,
        )
    }

    companion object {
        fun fromMap(map: Map<String, Any?>): Card {
            val cardModel = Card()
            cardModel.id = map["id"] as String?
            cardModel.title = map["title"] as String?
            cardModel.price = map["price"] as Number?
            cardModel.image = map["image"] as String?
            cardModel.specialitis = map["specialitis"] as String?
            cardModel.rating = map["rating"] as Number?
            return cardModel
        }
    }
}