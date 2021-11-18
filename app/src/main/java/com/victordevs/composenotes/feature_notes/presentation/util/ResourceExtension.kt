/*
 * Create by Byron Solorzano on 15/7/2020.
 *
 * Copyright (c) 2020 Byron Solorzano.
 * All rights reserved.
 */

package com.victordevs.composenotes.feature_notes.presentation.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

fun Context?.getResourceDrawable(id: Int): Drawable? {
    return if (this != null) {
        ContextCompat.getDrawable(this, id)
    } else null
}

fun Context?.getResourceColor(id: Int): Int {
    return if (this != null && id != 0) {
        ContextCompat.getColor(this, id)
    } else 0
}

fun Context?.getResourceBitmap(resource: Int): Bitmap? {
    return if (this != null) {
        (getResourceDrawable(resource) as BitmapDrawable).bitmap
    } else null
}
