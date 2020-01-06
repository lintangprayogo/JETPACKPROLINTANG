package com.lintang.jetpackprolintang.base.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.lintang.jetpackprolintang.base.utils.BaseHelper
import com.lintang.jetpackprolintang.base.viewmodel.ViewModelFactory

abstract class BaseFragment : Fragment() {

    lateinit var mActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = (activity as BaseActivity)
    }


    protected inline fun <reified ClassActivity, Model> baseStartActivity(
        context: Context,
        extraKey: String,
        data: Model
    ) {
        val intent = Intent(context, ClassActivity::class.java)
        val extraData = BaseHelper().baseToJson(data)
        intent.putExtra(extraKey, extraData)
        context.startActivity(intent)
    }

    protected fun setupEventView(view: View, progress: Boolean) {
        if (progress) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected inline fun <reified T : ViewModel> obtainViewModel(): T {
        val factory: ViewModelFactory = ViewModelFactory.getInstance()
        return ViewModelProviders.of(this, factory).get(T::class.java)
    }
}
