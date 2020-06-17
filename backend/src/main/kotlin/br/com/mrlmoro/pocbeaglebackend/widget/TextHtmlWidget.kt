package br.com.mrlmoro.pocbeaglebackend.widget

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.ui.Text

@RegisterWidget
class TextHtmlWidget(
    val textWidget: Text
) : Widget()