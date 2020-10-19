package com.netlight.cleanarchitecturesample.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.netlight.cleanarchitecturesample.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_products) as NavHostFragment?
                ?: return
        host.arguments = intent.extras

        navController = host.navController
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_products)
        navController.setGraph(graph, intent.extras)


    }
}
