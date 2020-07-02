package br.com.mrlmoro.pocbeaglebackend.movie.action

import br.com.zup.beagle.annotation.RegisterAction
import br.com.zup.beagle.widget.action.Action

@RegisterAction
data class SendMovieLikeAction(
    val movieId: String
) : Action