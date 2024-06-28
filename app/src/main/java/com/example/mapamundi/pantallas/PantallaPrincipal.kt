package com.example.mapamundi.pantallas


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mapamundi.R
import com.example.mapamundi.navigation.NavPantallas


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal (navController: NavController) {
    Scaffold(
        // Barra superior
        topBar = { PersonalizarTopBar() },

        // Barra inferior
        bottomBar = { PersonalizarBottomBar() },

        // Contenido principal
        content = { padding ->
            ContenidoScaffold(padding, navController)
        }
    )
}

@Composable
fun ContenidoScaffold(padding: PaddingValues, navController: NavController) {
    LazyColumn(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.logo), contentScale = ContentScale.FillBounds)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        // Contenido de la aplicación
        content = {
            item { Spacer(modifier = Modifier.height(45.dp)) }
            item {
                Button(
                    onClick = { navController.navigate(NavPantallas.PantallaContinente.route) }) {
                    Text(text = stringResource(id = R.string.por_pais))
                }
            }
            item { Spacer(modifier = Modifier.height(20.dp))  }
            item {
                Button(
                    onClick = { navController.navigate(NavPantallas.PantallaContinente2.route) }) {
                    Text(text = stringResource(id = R.string.por_capital))
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalizarTopBar() {
    TopAppBar(
        // Título de la barra superior
        title = { Text(text = stringResource(id = R.string.app_name)) },
    )
}

@Composable
fun PersonalizarBottomBar() {
    BottomAppBar(content = {
        // Contenido de la barra inferior
        Text(text = stringResource(id = R.string.inicio))
    })
}

