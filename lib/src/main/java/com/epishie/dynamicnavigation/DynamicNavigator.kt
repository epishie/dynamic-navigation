package com.epishie.dynamicnavigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import androidx.navigation.Navigator


@Navigator.Name("dynamicGraph")
class DynamicNavigator(navController: NavController) :
    NavGraphNavigator(navController.navigatorProvider) {
    private val navInflater = navController.navInflater

    override fun createDestination(): NavGraph {
        return DynamicNavGraph(this, navInflater)
    }
}
