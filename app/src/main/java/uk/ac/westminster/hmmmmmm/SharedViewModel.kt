package uk.ac.westminster.hmmmmmm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _name = MutableLiveData<String>()
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _age = MutableLiveData<Int>()
    private val _selectedOption = MutableLiveData<String>()

    val name: LiveData<String> get() = _name
    val email: LiveData<String> get() = _email
    val password: LiveData<String> get() = _password
    val age: LiveData<Int> get() = _age
    val selectedOption: LiveData<String> get() = _selectedOption

    fun saveRegistrationData(
        name: String,
        email: String,
        password: String,
        age: Int,
        selectedOption: String
    ) {
        _name.value = name
        _email.value = email
        _password.value = password
        _age.value = age
        _selectedOption.value = selectedOption
    }
}
