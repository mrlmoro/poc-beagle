package br.com.mrlmoro.pocbeagleandroid.widget

import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import androidx.core.widget.TextViewCompat
import br.com.mrlmoro.pocbeagleandroid.beagle.AppDesignSystem
import br.com.zup.beagle.android.components.Text
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.TextAlignment

@RegisterWidget
class TextHtmlWidget(
    private val textWidget: Text
) : WidgetView() {

    override fun buildView(rootView: RootView) = AppCompatTextView(rootView.getContext()).apply {
        AppDesignSystem().textStyle(textWidget.styleId ?: "").let {
            TextViewCompat.setTextAppearance(this, it)
        }

        //TODO understand why Bind value is Any type

        textWidget.alignment?.value
            ?.takeIf { it is TextAlignment }
            ?.let { it as TextAlignment }
            ?.apply {
                gravity = when (this) {
                    TextAlignment.CENTER -> Gravity.CENTER
                    TextAlignment.RIGHT -> Gravity.END
                    else -> Gravity.START
                }
            }

        textWidget.textColor?.value
            ?.takeIf { it is String }
            ?.let { it as String }
            ?.apply {
                setTextColor(toAndroidColor())
            }

        textWidget.text.value
            .takeIf { it is String }
            ?.let { it as String }
            ?.apply {
                text = HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)
            }
    }

}