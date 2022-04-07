package com.grzeluu.housingassociationmanager.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grzeluu.housingassociationmanager.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

lateinit var binding: ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}