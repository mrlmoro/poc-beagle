package br.com.mrlmoro.pocbeagleandroid.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import br.com.mrlmoro.pocbeagleandroid.widget.CustomButtonWidget
import br.com.zup.beagle.android.components.Button
import br.com.zup.beagle.android.components.Text
import br.com.zup.beagle.android.components.layout.Container
import br.com.zup.beagle.android.utils.toView
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.*

class DefaultDialogFragment : DialogFragment() {

    companion object {
        const val TAG = "DefaultDialogFragment"
        const val MESSAGE_KEY = "message-key"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DialogViewBuilder(
            message = arguments?.getString(MESSAGE_KEY) ?: ""
        ).build(this)
    }

    private class DialogViewBuilder(
        private val message: String
    ) {

        fun build(fragment: DialogFragment) = Container(
            children = listOf(
                Text(
                    text = message,
                    alignment = TextAlignment.CENTER
                ).applyFlex(
                    Flex(
                        grow = 1.0
                    )
                ).applyStyle(
                    Style(
                        margin = EdgeValue(
                            all = 16.unitReal()
                        )
                    )
                ),
                CustomButtonWidget(
                    Button(
                        text = "Ok",
                        styleId = "rounded",
                        onPress = listOf(DismissDialogAction())
                    )
                ).applyStyle(
                    Style(
                        margin = EdgeValue(
                            all = 16.unitReal()
                        )
                    )
                )
            )
        ).applyStyle(
            Style(
                size = Size(
                    width = 280.unitReal(),
                    maxWidth = 280.unitReal()
                )
            )
        ).toView(fragment)
    }
}
