package com.example.gabrielitagyba_rm87098

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Dados(
    var nome: String ="Oliver, o gatinho triste!",
    var descicao: String = "Era uma vez um gatinho triste chamado Oliver. Ninguém parecia amá-lo e ele se sentia sozinho. Oliver buscava carinho, mas era constantemente rejeitado. Ele desejava encontrar alguém que o amasse e aceitasse como ele era.",
    var habilidades: MutableList<String>
    ): Parcelable
