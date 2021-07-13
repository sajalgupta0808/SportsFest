package com.bitbyte.sportsfest.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bitbyte.sportsfest.R

class ItemCard(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private var name:TextView
    private var image:ImageView

    init{
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.card_item,this,true)
        image = view.findViewById(R.id.icon)
        name = view.findViewById(R.id.name)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ItemCard,
            0, 0).apply {

            try {
                name.text = getString(R.styleable.ItemCard_text)
                image.setImageDrawable(getDrawable(R.styleable.ItemCard_icon))
                view.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            } finally {
                recycle()
            }
        }
    }

    fun getText():String{
        return name.text.toString()
    }

    fun setText(text:String?){
        name.text = text
    }

    fun getIcon(): Drawable {
        return image.drawable
    }

    fun setIcon(drawable: Drawable){
        image.setImageDrawable(drawable)
    }
}