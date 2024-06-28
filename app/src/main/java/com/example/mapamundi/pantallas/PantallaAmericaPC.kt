package com.example.mapamundi.pantallas

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mapamundi.R
import com.example.mapamundi.modelo.PantallaAmericaPCviewModel
import com.example.mapamundi.navigation.NavPantallas


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAmericaPC(navController: NavController) {
    var situacion = LocalContext.current
    Scaffold(
        topBar = { PersonalizarTopBar10() },
        bottomBar = { PersonalizarBottomBar10() },
        content = { padding ->
            ContenidoScaffold10(padding, navController, contexto = situacion )
        }
    )
}

@Composable
fun ContenidoScaffold10(
    padding: PaddingValues,
    navController: NavController,
    europaViewModel: PantallaAmericaPCviewModel = viewModel(),
    contexto: Context
    //contexto: Context = LocalContext.current
){
    val gameUIState by europaViewModel.uiState.collectAsState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Spacer(modifier = Modifier.height(75.dp))
            GameLayout10(
                onIntentoUsuarioCambiado = { europaViewModel.actualizarIntentoUsuario(it) },
                intentoUsuario = europaViewModel.intentoUsuario,
                onKeyBoardDone = {
                    europaViewModel.checkIntentoUsuario()
                    if (europaViewModel.estadoFallo){
                        Toast.makeText(contexto,
                            "Error, la capital de ${gameUIState.pregunta} era ${gameUIState.respuesta}",
                            Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(contexto, "Acierto", Toast.LENGTH_SHORT).show()
                    }
                },
                pregunta = gameUIState.pregunta,
                aciertos = europaViewModel.arrayAciertos.size,
                fallo = europaViewModel.maxFallos
            )
            if (gameUIState.gameOver) {
                DialogoFinal10(
                    onPlayAgain = { europaViewModel.iniciarGame() },
                    volver = {
                        navController.navigate(NavPantallas.PantallaPrincipal.route)
                    },
                    aciertos = europaViewModel.arrayAciertos.size,
                    porcentajeAciertos = gameUIState.aciertos/ europaViewModel.tam.toDouble()

                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun GameLayout10(
    pregunta: String,
    intentoUsuario: String,
    onIntentoUsuarioCambiado: (String) -> Unit,
    onKeyBoardDone: () -> Unit,
    aciertos: Int,
    fallo: Int
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column {
        Text(
            textAlign = TextAlign.Justify,
            text = pregunta,
            fontWeight = FontWeight.W500
        )
        Spacer(modifier = Modifier.height(35.dp))
        OutlinedTextField(
            value = intentoUsuario,
            onValueChange = onIntentoUsuarioCambiado,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Characters
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onKeyBoardDone()
                    keyboardController?.hide()
                }
            )
        )
        Spacer(modifier = Modifier.height(75.dp))
        Text(
            text = "Nº de aciertos: ${aciertos.toString()}",
            color = Color.Green)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Vidas: ${fallo.toString()}",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun DialogoFinal10(
    onPlayAgain: () -> Unit,
    volver: () -> Unit,
    aciertos : Int,
    porcentajeAciertos: Double
) {
    AlertDialog(
        onDismissRequest = { },
        dismissButton = {
            TextButton(onClick = {
                volver()
            }
            ) {
                Text(text = "Volver")
            }
        },
        confirmButton = {
            TextButton(onClick = { onPlayAgain() }) {
                Text(text = "Jugar de nuevo")
            }
        },
        title = {
            Text(text = stringResource(id = R.string.resultados))
        },
        text = {
            Text(text = "Has acertado $aciertos capitales, el ${String.format("%.2f", porcentajeAciertos*100)} %")
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalizarTopBar10() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
    )
}

@Composable
fun PersonalizarBottomBar10() {
    BottomAppBar(content = {
        // Contenido de la barra inferior
        Text(text = stringResource(id = R.string.america))
    })
}


