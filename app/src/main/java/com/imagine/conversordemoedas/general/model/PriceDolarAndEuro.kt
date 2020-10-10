package com.imagine.conversordemoedas.general.model


import com.google.gson.annotations.SerializedName

data class PriceDolarAndEuro(
    @SerializedName("EUR")
    val eUR: EUR,
    @SerializedName("USD")
    val uSD: USD
) {
    data class EUR(
        @SerializedName("ask")
        val ask: Double,
        @SerializedName("bid")
        val bid: String,
        @SerializedName("code")
        val code: String,
        @SerializedName("codein")
        val codein: String,
        @SerializedName("create_date")
        val createDate: String,
        @SerializedName("high")
        val high: String,
        @SerializedName("low")
        val low: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("pctChange")
        val pctChange: String,
        @SerializedName("timestamp")
        val timestamp: String,
        @SerializedName("varBid")
        val varBid: String
    )

    data class USD(
        @SerializedName("ask")
        val ask: Double,
        @SerializedName("bid")
        val bid: String,
        @SerializedName("code")
        val code: String,
        @SerializedName("codein")
        val codein: String,
        @SerializedName("create_date")
        val createDate: String,
        @SerializedName("high")
        val high: String,
        @SerializedName("low")
        val low: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("pctChange")
        val pctChange: String,
        @SerializedName("timestamp")
        val timestamp: String,
        @SerializedName("varBid")
        val varBid: String
    )
}