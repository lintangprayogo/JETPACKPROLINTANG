package com.lintang.jetpackprolintang.base.ui


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.lintang.jetpackprolintang.base.utils.BaseHelper
import com.lintang.jetpackprolintang.base.viewmodel.ViewModelFactory

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this

    }


    protected inline fun <reified Model> baseGetExtraData(extraKey: String): Model {
        val extraIntent = intent.getStringExtra(extraKey)
        val extraData = BaseHelper().baseFromJson<Model>(extraIntent)
        return extraData
    }


    protected fun checkExtra(extraKey: String): Boolean {
        return intent?.hasExtra(extraKey)!!
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    protected inline fun <reified ClassActivity> baseStartActivity(
        context: Context
    ) {
        val intent = Intent(context, ClassActivity::class.java)
        startActivity(intent)

    }

    protected inline fun <reified T : ViewModel> obtainViewModel(): T {
        val factory: ViewModelFactory = ViewModelFactory.getInstance(mActivity.application)
        return ViewModelProviders.of(this, factory).get(T::class.java)
    }

}