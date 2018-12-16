package com.ruland.davidr.holidaywishlist.screens.splash.wish

import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import com.ruland.davidr.holidaywishlist.R
import com.ruland.davidr.holidaywishlist.databinding.ActivityWishBinding
import com.ruland.davidr.holidaywishlist.databinding.ContentListWishBinding
import com.ruland.davidr.holidaywishlist.databinding.DialogAddWishBinding
import com.ruland.davidr.holidaywishlist.screens.splash.data.AppDatabase
import com.ruland.davidr.holidaywishlist.screens.splash.data.DatabaseCreate

class WishActivity : AppCompatActivity() {
    private lateinit var activitysBinding: ActivityWishBinding
    private lateinit var wishAdapter: WishAdapter

    private lateinit var contentBinding: ContentListWishBinding
    private lateinit var appDatabase: AppDatabase
    private lateinit var wishDao: WishDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_wish)
        activitysBinding = DataBindingUtil.setContentView(this, R.layout.activity_wish)


        setupAddButton()
        appDatabase = DatabaseCreate.database!!
        wishDao = appDatabase.listCategoryDao()


        setupRecyclerAdapter()
    }

    override fun onResume() {
        super.onResume()
        AsyncTask.execute({
            wishAdapter.wishlist = wishDao.getAll()
            runOnUiThread { wishAdapter.notifyDataSetChanged() }
        })
    }


    private fun setupAddButton() {
        activitysBinding.fab.setOnClickListener {


            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Title")
            val dialogAddCategoryBinding = DialogAddWishBinding.inflate(layoutInflater)

            alertDialogBuilder.setView(dialogAddCategoryBinding.root)


            val wishViewModel = WishViewModel()
            dialogAddCategoryBinding.wishViewModel = wishViewModel


            alertDialogBuilder.setPositiveButton(android.R.string.ok, { dialog: DialogInterface,
                                                                        which: Int ->
                AsyncTask.execute({
                    wishDao.insertAll(wishViewModel.wish)
                    wishAdapter.wishlist = wishDao.getAll()
                    runOnUiThread { wishAdapter.notifyDataSetChanged() }
                })
            })

            alertDialogBuilder.setNegativeButton(android.R.string.cancel, { dialog: DialogInterface, which: Int -> })
            alertDialogBuilder.show()
        }
    }

    private fun setupRecyclerAdapter() {
        val recyclerViewLinearLayoutManager = LinearLayoutManager(this)
        contentBinding = activitysBinding.contentLists!!
        contentBinding.listCategoryRecyclerView.layoutManager = recyclerViewLinearLayoutManager
        wishAdapter = WishAdapter(listOf(), this)
        contentBinding.listCategoryRecyclerView.adapter = wishAdapter
    }
}