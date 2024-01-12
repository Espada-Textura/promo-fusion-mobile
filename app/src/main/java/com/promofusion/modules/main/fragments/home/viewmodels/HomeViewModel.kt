package com.promofusion.modules.main.fragments.home.viewmodels

import androidx.lifecycle.ViewModel
import com.promofusion.modules.main.fragments.home.models.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel()