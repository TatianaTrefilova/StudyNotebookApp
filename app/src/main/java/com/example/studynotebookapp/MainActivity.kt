package com.example.studynotebookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.studynotebookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Notes"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Notes())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.notes -> {
                    replaceFragment(Notes())
                    supportActionBar?.title = "Notes"
                }
                R.id.checklist -> {
                    replaceFragment(Checklist())
                    supportActionBar?.title = "Checklist"
                }
                R.id.done -> {
                    replaceFragment(Done())
                    supportActionBar?.title = "Done"
                }

                else ->{

                }

            }

            true

        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) finish()
        return true
    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}