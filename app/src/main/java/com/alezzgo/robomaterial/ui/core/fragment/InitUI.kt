package com.alezzgo.robomaterial.ui.core.fragment

interface InitUI {
    fun setupViews() = Unit

    fun setupListeners() = Unit

    fun observe() = Unit
}