package com.ruland.davidr.holidaywishlist.screens.splash.wish

import android.support.v7.widget.RecyclerView
import com.ruland.davidr.holidaywishlist.databinding.HolderWishBinding

data class WishViewHolder(private val holderListCategoryBinding: HolderWishBinding,
                          private val wishactivity: WishActivity) :
        RecyclerView.ViewHolder(holderListCategoryBinding.root) {

    fun setListCategoryItem(wish:  Wish) {
        val listCategoryViewModel = WishViewModel(wish)
        holderListCategoryBinding.wishItem = listCategoryViewModel
        holderListCategoryBinding.executePendingBindings()
    }
}