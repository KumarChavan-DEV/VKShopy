package com.vkdream.vkshopy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.vkdream.vkshopy.R
import com.vkdream.vkshopy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
        initListeners()
    }

    private fun initListeners() {
        binding.navView.ivHome.setOnClickListener { selectTab(1) }
        binding.navView.ivLocate.setOnClickListener { selectTab(2) }
        binding.navView.ivCart.setOnClickListener { selectTab(3) }
        binding.navView.ivProfile.setOnClickListener { selectTab(4) }
    }

    private fun selectTab(selectedTab: Int) {
        val colorSelected = ContextCompat.getColor(this@MainActivity, R.color.green)
        val colorDefault = ContextCompat.getColor(this@MainActivity, R.color.grey_4)
        binding.navView.ivHome.setColorFilter(colorDefault)
        binding.navView.ivLocate.setColorFilter(colorDefault)
        binding.navView.ivCart.setColorFilter(colorDefault)
        binding.navView.ivProfile.setColorFilter(colorDefault)
        when (selectedTab) {
            1 -> binding.navView.ivHome.setColorFilter(colorSelected)
            2 -> binding.navView.ivLocate.setColorFilter(colorSelected)
            3 -> binding.navView.ivCart.setColorFilter(colorSelected)
            4 -> binding.navView.ivProfile.setColorFilter(colorSelected)
        }
    }
}