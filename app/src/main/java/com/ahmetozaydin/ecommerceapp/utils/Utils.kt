package com.ahmetozaydin.ecommerceapp.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.ahmetozaydin.ecommerceapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Utils {
        companion object{
            fun vibrateDevice(context: Context) {
                val vibrator = getSystemService(context, Vibrator::class.java)
                vibrator?.let {
                    if (Build.VERSION.SDK_INT >= 26) {
                        it.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
                    } else {
                        @Suppress("DEPRECATION")
                        it.vibrate(50)
                    }
                }

            }
        }

}
fun Toast.makeToastMassage(message : String){
    TODO()
}
fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable){

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}
fun placeholderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}



