package com.example.mapamundi.navigation

sealed class NavPantallas (val route: String){
    object PantallaSplash: NavPantallas("pantallaSplash")
    object PantallaPrincipal: NavPantallas("pantallaPrincipal")
    object PantallaContinente: NavPantallas("pantallaContinente")
    object PantallaContinente2: NavPantallas("pantallaContinente2")
    object PantallaEuropaPP: NavPantallas("pantallaEuropaPP")
    object PantallaEuropaPC: NavPantallas("pantallaEuropaPC")
    object PantallaAmericaPP: NavPantallas("pantallaAmericaPP")
    object PantallaAmericaPC: NavPantallas("pantallaAmericaPC")
    object PantallaAsiaPP: NavPantallas("pantallaAsiaPP")
    object PantallaAsiaPC: NavPantallas("pantallaAsiaPC")
    object PantallaOceaniaPP: NavPantallas("pantallaOceaniaPP")
    object PantallaOceaniaPC: NavPantallas("pantallaOceaniaPC")
    object PantallaAfricaPP: NavPantallas("pantallaAfricaPP")
    object PantallaAfricaPC: NavPantallas("pantallaAfricaPC")
    object PantallaTodosPP: NavPantallas("pantallaTodosPP")
    object PantallaTodosPC: NavPantallas("pantallaTodosPC")
}