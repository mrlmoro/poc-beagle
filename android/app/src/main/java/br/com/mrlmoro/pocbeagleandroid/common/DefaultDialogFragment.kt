package br.com.mrlmoro.pocbeagleandroid.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import br.com.zup.beagle.action.CustomAction
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.utils.toView
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment

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
                        grow = 1.0,
                        margin = EdgeValue(
                            all = 16.unitReal()
                        )
                    )
                ),
                Button(
                    text = "Ok",
                    style = "rounded",
                    action = CustomAction(
                        name = "common:dismissDialog",
                        data = emptyMap()
                    )
                ).applyFlex(
                    Flex(
                        margin = EdgeValue(
                            all = 16.unitReal()
                        )
                    )
                )
            )
        ).applyFlex(
            Flex(
                grow = 1.0,
                justifyContent = JustifyContent.SPACE_BETWEEN,
                size = Size(
                    width = 280.unitReal(),
                    height = 280.unitReal()
                ),
                margin = EdgeValue(
                    all = 100.unitReal()
                )
            )
        ).toView(fragment)

    }
}
