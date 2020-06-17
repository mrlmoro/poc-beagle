package br.com.mrlmoro.pocbeagleandroid.widget

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import androidx.core.widget.TextViewCompat
import br.com.mrlmoro.pocbeagleandroid.beagle.AppDesignSystem
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment

@RegisterWidget
class TextHtmlWidget(
    private val textWidget: Text
) : WidgetView() {

    override fun buildView(context: Context) = AppCompatTextView(context).apply {
        AppDesignSystem().textAppearance(textWidget.style ?: "").let {
            TextViewCompat.setTextAppearance(this, it)
        }

        this.gravity = when (textWidget.alignment) {
            TextAlignment.CENTER -> Gravity.CENTER
            TextAlignment.RIGHT -> Gravity.END
            else -> Gravity.START
        }

        textWidget.textColor?.toAndroidColor()?.let {
            setTextColor(it)
        }

        text = HtmlCompat.fromHtml(textWidget.text, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun String.toAndroidColor(): Int {
        val hexColor = if (this.startsWith("#")) this else "#$this"
        return Color.parseColor(hexColor)
    }

}