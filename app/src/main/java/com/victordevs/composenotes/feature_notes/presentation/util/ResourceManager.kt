package com.victordevs.composenotes.feature_notes.presentation.util

import android.app.KeyguardManager
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import java.util.*

class ResourceManager(val context: Context) {

    val resources: Resources = context.resources

    fun getLanguage(): String = if (Locale.getDefault().language.equals("en", ignoreCase = true)) {
        "en"
    } else {
        "es"
    }

    fun getString(@StringRes resourceId: Int, params: Any? = null) = resources.getString(
        resourceId,
        params
    )

    fun getString(@StringRes resourceId: Int, params: Any? = null, params2: Any? = null) = resources.getString(
        resourceId,
        params,
        params2
    )

    fun getDrawable(resource: Int) = context.getResourceDrawable(resource)

    fun getDimensionPixelSize(@DimenRes res: Int) = resources.getDimensionPixelSize(res)

    fun getDimensionPixelOffset(@DimenRes res: Int) = resources.getDimensionPixelOffset(res)

    fun getDimension(@DimenRes res: Int) = resources.getDimension(res)

    fun getKeyguardManager() = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager?

    fun generateToast(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show()
    }
}
