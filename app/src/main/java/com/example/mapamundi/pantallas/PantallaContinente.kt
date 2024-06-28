package com.example.mapamundi.pantallas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mapamundi.R
import com.example.mapamundi.navigation.NavPantallas


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaContinente(navController: NavController) {
    Scaffold(
        // Barra superior
        topBar = { PersonalizarTopBar2() },

        // Barra inferior
        bottomBar = { PersonalizarBottomBar2() },

        // Contenido principal
        content = { padding ->
            ContenidoScaffold2(padding, navController)
        }
    )
}

@Composable
fun ContenidoScaffold2(padding: PaddingValues, navController: NavController) {
    LazyColumn(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.continentes), contentScale = ContentScale.FillBounds)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        // Contenido de la aplicación
        content = {
            item { Spacer(modifier = Modifier.height(45.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaEuropaPP.route) }) {
                    Text(
                        text = stringResource(id = R.string.europa),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaAmericaPP.route) }) {
                    Text(
                        text = stringResource(id = R.string.america),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaAsiaPP.route) }) {
                    Text(
                        text = stringResource(id = R.string.asia),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaOceaniaPP.route) }) {
                    Text(
                        text = stringResource(id = R.string.oceania),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaAfricaPP.route) }) {
                    Text(
                        text = stringResource(id = R.string.africa),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaTodosPP.route) }) {
                    Text(
                        text = stringResource(id = R.string.todos),
                        color = Color.White)
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalizarTopBar2() {
    TopAppBar(
        // Título de la barra superior
        title = { Text(text = stringResource(id = R.string.app_name)) },
    )
}

@Composable
fun PersonalizarBottomBar2() {
    BottomAppBar(content = {
        // Contenido de la barra inferior
        Text(text = stringResource(id = R.string.continentes))
    })
}