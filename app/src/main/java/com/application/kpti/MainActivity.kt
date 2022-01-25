package com.application.kpti

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.multi.SnackbarOnAnyDeniedMultiplePermissionsListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        constraintLayout = findViewById(R.id.container)
        //val navController = findNavController(R.id.nav_host_fragment)
        /*navController.addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.splashscreenFragment -> navView.visibility = View.GONE
                R.id.loginFragment -> navView.visibility = View.GONE
                R.id.registerFragment -> navView.visibility = View.GONE
                R.id.navigation_home -> navView.visibility = View.VISIBLE
                R.id.detailpropertyFragment -> navView.visibility = View.GONE
            }
        }*/

         /*Passing each menu ID as a set of Ids because each
         menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/
        getPermission()
    }

     fun getPermission()  {
        val snackbarMultiplePermissionsListener: MultiplePermissionsListener =
            SnackbarOnAnyDeniedMultiplePermissionsListener.Builder
                .with(constraintLayout, "Location access is needed!")
                .withOpenSettingsButton("Settings")
                .withCallback(object : Snackbar.Callback() {
                    override fun onShown(snackbar: Snackbar) {

                    }
                    override fun onDismissed(snackbar: Snackbar, event: Int) {
                        finish()
                    }
                })
                .build()

        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ).withListener(snackbarMultiplePermissionsListener)
            .withErrorListener {
                Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
            }.check()

    }

}