package com.example.gabrielitagyba_rm87098

object Theme {
    var currentTheme = R.style.Theme_GabrielItagyba_RM87098

    private const val ACTUAL = R.style.Theme_GabrielItagyba_RM87098
    private const val NEW = R.style.Theme_novoTema

    fun switchTheme() {
        Theme.currentTheme = when (Theme.currentTheme) {
            ACTUAL -> NEW
            NEW -> ACTUAL
            else -> -1
        }
    }
}