package com.codexmyanmar.chat_ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class AnswerContainer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    styleDef: Int = 0
): LinearLayout(context,attrs,styleDef) {

    init {
        orientation = LinearLayout.HORIZONTAL
    }

    fun addAnswerViews(answerText: String,chooseAnswerListener: (String) -> Unit){
        val answerTextView = AnswerTextView(context).apply {
            text = answerText
            setOnClickListener {
                chooseAnswerListener(text.toString().trim())
            }
        }
        addView(answerTextView)
    }
}