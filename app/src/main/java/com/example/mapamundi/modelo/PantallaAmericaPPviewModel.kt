package com.example.mapamundi.modelo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mapamundi.GameUIState
import com.example.mapamundi.calcularFallos
import com.example.mapamundi.iterarPregunta
import com.example.mapamundi.iterarRespuesta
import com.example.mapamundi.paisesAm
import com.example.mapamundi.paisesAmAleatorios
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class PantallaAmericaPPviewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUIState())
    val uiState: StateFlow<GameUIState> = _uiState.asStateFlow()

    var repoSingular = paisesAmAleatorios.toList()   /////ESPECIFICO
    var maxFallos = calcularFallos(paisesAm)    /////ESPECIFICO
    val tam = paisesAm.size   /////ESPECIFICO

    var arrayAciertos: MutableList<String> = mutableListOf()
    var arrayFallos: MutableList<String> = mutableListOf()

    var estadoFallo = false
    var iterador = 0
    var intentoUsuario by mutableStateOf("")
        private set

    init {
        iniciarGame()
    }

    fun iniciarGame() {
        estadoFallo = false
        iterador = 0
        repoSingular = paisesAmAleatorios.toList()   /////ESPECÍFICO
        maxFallos = calcularFallos(paisesAm)        //////ESPECÍFICO
        arrayAciertos.clear()
        arrayFallos.clear()
        _uiState.value = GameUIState(
            pregunta = iterarPregunta(repoSingular, iterador),
            respuesta = iterarRespuesta(repoSingular, iterador),
            aciertos = 0
        )
    }

    fun actualizarIntentoUsuario(palabraIntentada: String) {
        intentoUsuario = palabraIntentada
    }

    fun checkIntentoUsuario() {
        estadoFallo = false
        if (_uiState.value.respuesta.equals(intentoUsuario)) {
            val aciertosActualizados = _uiState.value.aciertos.plus(1)
            arrayAciertos.add(intentoUsuario)
            repoSingular.drop(iterador)
            if (arrayAciertos.size == tam) {
                updateGameStateAciertoFinal(aciertosActualizados)
            } else {
                iterador += 1
                if (iterador == tam) {
                    iterador = 0
                    updateGameStateAciertos(aciertosActualizados)
                    actualizarIntentoUsuario("")
                } else {
                    updateGameStateAciertos(aciertosActualizados)
                    actualizarIntentoUsuario("")
                }
            }
        } else if (maxFallos > 0) {
            estadoFallo = true
            arrayFallos.add(_uiState.value.respuesta)
            if ((arrayAciertos.size + arrayFallos.size) >= tam) {
                maxFallos -= 1
                _uiState.update { currentState ->
                    currentState.copy(
                        gameOver = true
                    )
                }
                actualizarIntentoUsuario("")
            } else {
                iterador += 1
                maxFallos -= 1
                updateGameState()
                actualizarIntentoUsuario("")
            }
        } else {
            estadoFallo = true
            _uiState.update { currentState ->
                currentState.copy(
                    gameOver = true
                )
            }
        }
    }

    fun updateGameState() {
        _uiState.update { currentState ->
            currentState.copy(
                pregunta = iterarPregunta(repoSingular, iterador),
                respuesta = iterarRespuesta(repoSingular, iterador),
            )
        }
    }

    fun updateGameStateAciertos(anadido: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                pregunta = iterarPregunta(repoSingular, iterador),
                respuesta = iterarRespuesta(repoSingular, iterador),
                aciertos = anadido
            )
        }
    }

    fun updateGameStateAciertoFinal(anadido: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                aciertos = anadido,
                gameOver = true
            )
        }
        actualizarIntentoUsuario("")
    }
}