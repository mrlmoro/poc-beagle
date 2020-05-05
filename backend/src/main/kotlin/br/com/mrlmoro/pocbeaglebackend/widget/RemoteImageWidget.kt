package br.com.mrlmoro.pocbeaglebackend.widget

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.ImageContentMode

@RegisterWidget
class RemoteImageWidget(
    val url: String,
    val contentMode: ImageContentMode
) : Widget()