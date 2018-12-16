package com.ruland.davidr.holidaywishlist.screens.splash.wish

import android.util.Log
import com.ruland.davidr.holidaywishlist.R

data class WishViewModel(val wish: Wish = Wish("","","","")) {

    private val highlightColors = arrayOf(
            R.color.colorTest, R.color.colorBlue, R.color.colorBlueDark)

    fun getHighlightLetter(): String {
        return wish.categoryName.first().toString()
    }

    fun getHighlightLetterColor(): Int {
        val uniqueIdMultiplier = getHighlightLetter().hashCode().div(3)
        val colorArrayIndex = getHighlightLetter().hashCode() - (uniqueIdMultiplier * 3)
        Log.i("color", colorArrayIndex.toString())
        return (highlightColors[colorArrayIndex])
    }
}