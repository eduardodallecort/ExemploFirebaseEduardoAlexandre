package br.edu.unisep.exemplofb.di

import br.edu.unisep.exemplofb.repository.UserRepository
import br.edu.unisep.exemplofb.ui.register.viewmodel.RegisterUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { UserRepository()}
}

val viewModelModule = module {
    viewModel { RegisterUserViewModel() }
}
