package com.showti.core.utils

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment


@SuppressLint("LogNotTimber")
fun Fragment.debugLog(msg:String) = Log.d(this::class.java.simpleName,msg)

fun Fragment.toastMsg(msg:String) = Toast.makeText(this.context,msg,Toast.LENGTH_LONG).show()