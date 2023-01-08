package dev.prabhatpandey.instacompose.profile.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prabhatpandey.instacompose.core.di.DispatcherProvider
import dev.prabhatpandey.instacompose.profile.domain.models.PhotoModel
import dev.prabhatpandey.instacompose.profile.domain.usecases.GetPhotosUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val getPhotos: GetPhotosUseCase
): ViewModel() {

    private val _photos = MutableStateFlow<List<PhotoModel>>(emptyList())
    val photos = _photos.asStateFlow()

    private val _snackBarError = MutableSharedFlow<String>()
    val snackBarError = _snackBarError.asSharedFlow()

    init {
        loadPhotos()
    }

    private fun loadPhotos() {
        viewModelScope.launch(dispatchers.io()) {
            getPhotos()
                .onSuccess { list ->
                    _photos.update { list }
                }
                .onFailure {
                    _snackBarError.emit(it.message ?: "Some error occurred")
                }
        }
    }
}