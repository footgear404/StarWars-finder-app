package com.semenchuk.starwars_finder_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.semenchuk.starwars_finder_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = addNavigation()
    }

    private fun addNavigation(): NavController {
        val navView: BottomNavigationView = binding.navView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)

//        navView.setOnItemReselectedListener { item ->
//            navController.navigate(
//                resId = item.itemId,
//                args = null,
//                navOptions = NavOptions.Builder()
//                    .setPopUpTo(destinationId = item.itemId, inclusive = true)
//                    .setLaunchSingleTop(true)
//                    .build()
//            )
//        }
        return navController
    }
}