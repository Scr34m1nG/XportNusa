package com.adyatma.xportnusa.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.adyatma.xportnusa.R

class EditTextPassword: AppCompatEditText {

    private lateinit var iconPassword: Drawable

    constructor(context: Context) : super(context) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initialize()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        transformationMethod = PasswordTransformationMethod.getInstance()
    }

    private fun initialize() {
        iconPassword = ContextCompat.getDrawable(context, R.drawable.ic_lock_24) as Drawable
        inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        setHint(R.string.hint_password)
        compoundDrawablePadding = 16
        drawable(iconPassword)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setAutofillHints(AUTOFILL_HINT_PASSWORD)
        }

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("Not yet implemented")
            }

            override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {
                if (!char.isNullOrEmpty() && char.length <= 8) {
                    error = context.getString(R.string.error_password)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                //TODO("Not yet implemented")
            }

        })
    }

    private fun drawable(
        start: Drawable? = null,
        end: Drawable? = null,
        top: Drawable? = null,
        bottom: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(start, end, top, bottom)
    }
}