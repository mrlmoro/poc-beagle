package br.com.mrlmoro.pocbeaglebackend.widget

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.ui.Button

@RegisterWidget
class CustomButtonWidget(
    val buttonWidget: Button
) : Widget()