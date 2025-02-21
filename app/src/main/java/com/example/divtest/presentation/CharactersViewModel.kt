package com.example.divtest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.divtest.domain.ICharactersInteractor
import com.example.divtest.data.model.CharactersDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val iCharactersInteractor: ICharactersInteractor,
):ViewModel() {

    private val _all = MutableLiveData<List<CharactersDomain>>()
    val all: LiveData<List<CharactersDomain>>
        get() = _all


    init {
        getAllCharacters()
    }

    fun getAllCharacters() = viewModelScope.launch{

        iCharactersInteractor.getCharactersApi().let {
            if (it.isSuccessful){
                _all.postValue(it.body())
            }else{
                Log.d("checkData", "Failed to load list : ${it.errorBody()}")
            }
        }
    }


}