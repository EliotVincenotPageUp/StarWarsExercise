package com.example.starwarspoc.ui.profil



sealed interface ProfilEvent {
    data object CreateTestUser :  ProfilEvent

}