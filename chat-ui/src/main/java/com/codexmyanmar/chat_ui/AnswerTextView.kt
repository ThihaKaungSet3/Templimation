package com.codexmyanmar.chat_ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import non.shahad.common_ui.dpToPx

class AnswerTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    styleDef: Int = 0
): AppCompatTextView(context,attrs,styleDef){

    init {
        originalStyling()
        position()
        minLines = 2
    }


    private fun position(){
        setPadding(context.dpToPx(16),context.dpToPx(8),context.dpToPx(16),context.dpToPx(8))

        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(context.dpToPx(8),context.dpToPx(8),context.dpToPx(8),context.dpToPx(8))
        }

        layoutParams = params
    }

    private fun originalStyling(){
        val gradient = GradientDrawable().apply {
            setColor(Color.WHITE)
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 16f
            setStroke(context.dpToPx(1),Color.parseColor("#F1F2F9"))
        }

        background = gradient
        setTextColor(Color.GRAY)
    }
}