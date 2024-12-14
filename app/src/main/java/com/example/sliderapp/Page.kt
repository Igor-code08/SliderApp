package com.example.sliderapp

import java.io.Serializable

data class Page(
    val title: String,
    val url: String
): Serializable{
    companion object {
        fun getPages(): List<Page> {
            return listOf(
                Page("Новости", "https://news.google.com"),
                Page("Музыка", "https://www.spotify.com"),
                Page("Кино", "https://www.imdb.com"),
                Page("Технологии", "https://www.techcrunch.com")
            )
        }
    }
}