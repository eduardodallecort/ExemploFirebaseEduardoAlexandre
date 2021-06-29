package br.edu.unisep.exemplofb.ui.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.exemplofb.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterUserViewModel : ViewModel() {

    private val repository = UserRepository()

    fun save(username: String, password: String): String {
        var message = "Usuário cadastrado com sucesso!"
        viewModelScope.launch {
            var message = repository.save(username, password)
        }
        return message
    }
}