package com.ruland.davidr.holidaywishlist.screens.splash.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ruland.davidr.holidaywishlist.screens.splash.wish.Wish
import com.ruland.davidr.holidaywishlist.screens.splash.wish.WishDao

@Database(entities = [(Wish::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun listCategoryDao(): WishDao
}