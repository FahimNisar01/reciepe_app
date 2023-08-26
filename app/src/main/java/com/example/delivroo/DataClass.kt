package com.example.delivroo

data class CategoryData(val image:Int,val name:String)
data class FeaturedData(val image:Int,val name:String,val location:String,var isClicked: Boolean = false)