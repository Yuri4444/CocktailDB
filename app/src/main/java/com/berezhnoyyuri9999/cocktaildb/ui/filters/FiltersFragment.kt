package com.berezhnoyyuri9999.cocktaildb.ui.filters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.cocktaildb.MainActivity
import com.berezhnoyyuri9999.cocktaildb.MainActivityBridge
import com.berezhnoyyuri9999.cocktaildb.R
import com.berezhnoyyuri9999.cocktaildb.databinding.FragmentFiltersBinding
import kotlinx.android.synthetic.main.fragment_filters.*

class FiltersFragment : Fragment() {

    private lateinit var mainActivityBridge: MainActivityBridge
    private lateinit var _binding: FragmentFiltersBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivityBridge = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFiltersBinding.inflate(layoutInflater, container, false)

        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.btnApply.setOnClickListener {
            mainActivityBridge.navController()
                .navigate(R.id.action_filtersFragment_to_listCocktailsFragment)
        }
    }

}