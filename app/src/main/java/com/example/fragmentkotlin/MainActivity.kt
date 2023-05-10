package com.example.fragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmentkotlin.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.miHome->setCurrentFragment(firstFragment)
                R.id.miMessage->setCurrentFragment(secondFragment)
                R.id.miProfile->setCurrentFragment(thirdFragment)
            }
            true
        }
        binding.bottomNavigationView.getOrCreateBadge(R.id.miMessage).apply {
            number = 10
            isVisible =true
        }


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,firstFragment)
            commit()
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,secondFragment)
                addToBackStack(null)
                commit()
            }
        }


        //bottom nav



    }

    private fun setCurrentFragment(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }
}