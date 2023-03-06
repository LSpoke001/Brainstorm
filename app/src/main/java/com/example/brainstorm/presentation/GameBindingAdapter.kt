package com.example.brainstorm.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

interface OnClickToChooseAnswerListener{
    fun onClickAnswer(number: Int)
}

@BindingAdapter("textAsString")
fun bindingTextAsString(textView: TextView, number: Int){
    textView.text = number.toString()
}

@BindingAdapter("answersProgressColor")
fun bindingAnswersProgressColor(textView: TextView, enough: Boolean){
    textView.setTextColor(getColorByState(textView.context, enough))
}

@BindingAdapter("progressColor")
fun bindingProgressColor(progressBar: ProgressBar, enough: Boolean){
    val color = getColorByState(progressBar.context, enough)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

@BindingAdapter("progressAnimation")
fun bindingProgressAnimation(progressBar: ProgressBar,count: Int){
    progressBar.setProgress(count, true)
}

@BindingAdapter("clickChooseAnswer")
fun bindingClickChooseAnswer(textView: TextView, onClickToChooseAnswer: OnClickToChooseAnswerListener){
    textView.setOnClickListener {
        onClickToChooseAnswer.onClickAnswer(textView.text.toString().toInt())
    }
}

private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}