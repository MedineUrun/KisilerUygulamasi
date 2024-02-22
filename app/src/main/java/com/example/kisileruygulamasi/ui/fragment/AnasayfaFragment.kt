package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        binding.buttonDetay.setOnClickListener {
            val kisi = Kisiler(1, "Ahmet", "1111")
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi) //veri transferi yapıyoruz
            Navigation.findNavController(it).navigate(gecis)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(p0: String): Boolean { //harf girdikce ve sildikce  çalışır
                ara(p0)
                return true
            }

            override fun onQueryTextSubmit(p0: String): Boolean { //Klavyedeki arama butonu ile çalışır
                ara(p0)
                return true
            }
        })

        return binding.root
    }

    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara", aramaKelimesi)
    }
}