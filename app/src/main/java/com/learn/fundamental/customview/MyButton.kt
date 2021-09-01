package com.learn.fundamental.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.learn.fundamental.R

class MyButton : AppCompatButton {

    private var enabledBackground: Drawable? = null
    private var disableBackground: Drawable? = null
    private var txtColor: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        init()

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = when{
            isEnabled -> enabledBackground
            else -> disableBackground
        }
        setTextColor(txtColor)
        textSize = 12f

        gravity = Gravity.CENTER
        text = when {
            isEnabled -> "Submit"
            else -> "Isi Dulu"
        }
    }

    private fun init() {
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ResourcesCompat.getDrawable(resources, R.drawable.bg_button, null)
        disableBackground = ResourcesCompat.getDrawable(resources, R.drawable.bg_button_disable, null)
    }
}