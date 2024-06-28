package com.example.mapamundi.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.mapamundi.R
import com.example.mapamundi.navigation.NavPantallas
import kotlinx.coroutines.delay

@Composable
fun PantallaSplash (navController: NavController){
    LaunchedEffect(key1 = true){
        delay(3000)  // milisegundos con la PantallaSplash
        navController.popBackStack()   // quita de la pila a la PantallaSplash
        navController.navigate(NavPantallas.PantallaPrincipal.route) // ya fuera de la pila, a la pantalla principal
    }
    Splash()
}

@Composable
fun Splash() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            contentScale = ContentScale.Crop)
    }
}