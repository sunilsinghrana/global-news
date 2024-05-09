package com.example.newsapp.data.converter

import androidx.room.TypeConverter
import com.example.newsapp.domain.model.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson= Gson()

    @TypeConverter
    fun fromSource(source: Source):String{
        return gson.toJson(source)
    }

    @TypeConverter
    fun toSource(json:String): Source {
        val type =object : TypeToken<Source>(){}.type
        return gson.fromJson(json,type)
    }
}