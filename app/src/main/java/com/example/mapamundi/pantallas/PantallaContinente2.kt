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
fun PantallaContinente2(navController: NavController) {
    Scaffold(
        // Barra superior
        topBar = { PersonalizarTopBar4() },

        // Barra inferior
        bottomBar = { PersonalizarBottomBar4() },

        // Contenido principal
        content = { padding ->
            ContenidoScaffold4(padding, navController)
        }
    )
}

@Composable
fun ContenidoScaffold4(padding: PaddingValues, navController: NavController) {
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
                    onClick = { navController.navigate(NavPantallas.PantallaEuropaPC.route) }) {
                    Text(
                        text = stringResource(id = R.string.europa),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaAmericaPC.route) }) {
                    Text(
                        text = stringResource(id = R.string.america),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaAsiaPC.route) }) {
                    Text(
                        text = stringResource(id = R.string.asia),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaOceaniaPC.route) }) {
                    Text(
                        text = stringResource(id = R.string.oceania),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaAfricaPC.route) }) {
                    Text(
                        text = stringResource(id = R.string.africa),
                        color = Color.White
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(25.dp)) }
            item {
                OutlinedButton(
                    onClick = { navController.navigate(NavPantallas.PantallaTodosPC.route) }) {
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
fun PersonalizarTopBar4() {
    TopAppBar(
        // Título de la barra superior
        title = { Text(text = stringResource(id = R.string.app_name)) },
    )
}

@Composable
fun PersonalizarBottomBar4() {
    BottomAppBar(content = {
        // Contenido de la barra inferior
        Text(text = stringResource(id = R.string.continentes))
    })
}