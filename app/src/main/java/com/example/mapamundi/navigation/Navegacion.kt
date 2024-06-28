package com.example.mapamundi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mapamundi.pantallas.PantallaAfricaPC
import com.example.mapamundi.pantallas.PantallaAfricaPP
import com.example.mapamundi.pantallas.PantallaAmericaPC
import com.example.mapamundi.pantallas.PantallaAmericaPP
import com.example.mapamundi.pantallas.PantallaAsiaPC
import com.example.mapamundi.pantallas.PantallaAsiaPP
import com.example.mapamundi.pantallas.PantallaContinente
import com.example.mapamundi.pantallas.PantallaContinente2
import com.example.mapamundi.pantallas.PantallaEuropaPC
import com.example.mapamundi.pantallas.PantallaEuropaPP
import com.example.mapamundi.pantallas.PantallaOceaniaPC
import com.example.mapamundi.pantallas.PantallaOceaniaPP
import com.example.mapamundi.pantallas.PantallaPrincipal
import com.example.mapamundi.pantallas.PantallaSplash
import com.example.mapamundi.pantallas.PantallaTodosPC
import com.example.mapamundi.pantallas.PantallaTodosPP

@Composable
fun Navegacion (){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavPantallas.PantallaSplash.route){
        composable(NavPantallas.PantallaSplash.route){
            PantallaSplash(navController)
        }
        composable(NavPantallas.PantallaPrincipal.route){
            PantallaPrincipal(navController)
        }
        composable(NavPantallas.PantallaContinente.route){
            PantallaContinente(navController)
        }
        composable(NavPantallas.PantallaContinente2.route){
            PantallaContinente2(navController)
        }
        composable(NavPantallas.PantallaEuropaPP.route){
            PantallaEuropaPP(navController)
        }
        composable(NavPantallas.PantallaEuropaPC.route){
            PantallaEuropaPC(navController)
        }
        composable(NavPantallas.PantallaAmericaPP.route){
            PantallaAmericaPP(navController)
        }
        composable(NavPantallas.PantallaAmericaPC.route){
            PantallaAmericaPC(navController)
        }
        composable(NavPantallas.PantallaAfricaPP.route){
            PantallaAfricaPP(navController)
        }
        composable(NavPantallas.PantallaAfricaPC.route){
            PantallaAfricaPC(navController)
        }
        composable(NavPantallas.PantallaAsiaPP.route){
            PantallaAsiaPP(navController)
        }
        composable(NavPantallas.PantallaAsiaPC.route){
            PantallaAsiaPC(navController)
        }
        composable(NavPantallas.PantallaOceaniaPP.route){
            PantallaOceaniaPP(navController)
        }
        composable(NavPantallas.PantallaOceaniaPC.route){
            PantallaOceaniaPC(navController)
        }
        composable(NavPantallas.PantallaTodosPP.route){
            PantallaTodosPP(navController)
        }
        composable(NavPantallas.PantallaTodosPC.route){
            PantallaTodosPC(navController)
        }
    }
}