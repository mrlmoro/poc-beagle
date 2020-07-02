package br.com.mrlmoro.pocbeagleandroid.widget

import android.view.View
import androidx.appcompat.view.ContextThemeWrapper
import br.com.mrlmoro.pocbeagleandroid.beagle.AppAnalyticsHandler
import br.com.mrlmoro.pocbeagleandroid.beagle.AppDesignSystem
import br.com.zup.beagle.android.components.Button
import br.com.zup.beagle.android.utils.observeBindChanges
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget

/**
 * Created by Murilo Moro on 01/07/20.
 */
@RegisterWidget
class CustomButtonWidget(
    private val buttonWidget: Button
) : WidgetView() {

    override fun buildView(rootView: RootView): View {
        val styleId = AppDesignSystem().buttonStyle(buttonWidget.styleId ?: "")
        return android.widget.Button(
            ContextThemeWrapper(rootView.getContext(), styleId),
            null,
            styleId
        ).apply {
            observeBindChanges(rootView, buttonWidget.text) {
                text = it
            }

            setOnClickListener {
                buttonWidget.clickAnalyticsEvent?.run {
                    AppAnalyticsHandler().trackEventOnClick(this)
                }

                buttonWidget.onPress?.forEach { it.execute(rootView) }
            }
        }
    }
}