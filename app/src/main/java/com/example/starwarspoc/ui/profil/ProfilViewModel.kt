package com.example.starwarspoc.ui.profil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarspoc.data.datasource.database
import com.example.starwarspoc.data.datasource.local.dao.UserDao
import com.example.starwarspoc.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

 class ProfilViewModel: ViewModel() {

    private val _state = MutableStateFlow(ProfilState())
    val state: StateFlow<ProfilState> = _state.asStateFlow()


     fun onEvent(event: ProfilEvent) {
         when (event) {
             ProfilEvent.CreateTestUser -> createTestUser()
         }
     }

     fun createTestUser() {
             viewModelScope.launch(Dispatchers.IO) {
                 val user = User(firstName = "Luke")
                 database?.userDao()?.insertUser(user)
             }
         }
     }

