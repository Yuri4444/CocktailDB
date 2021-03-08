package com.berezhnoyyuri9999.cocktaildb.ui.listCoctails

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.cocktaildb.CocktailClass
import com.berezhnoyyuri9999.cocktaildb.MainActivity
import com.berezhnoyyuri9999.cocktaildb.MainActivityBridge
import com.berezhnoyyuri9999.cocktaildb.R
import com.berezhnoyyuri9999.cocktaildb.data.model.DataCocktails
import com.berezhnoyyuri9999.cocktaildb.ui.adapters.CocktailAdapter
import kotlinx.android.synthetic.main.fragment_list_cocktails.*

class ListCocktailsFragment : Fragment(), ListCocktailContract.ListCocktailView {

    private lateinit var mainActivityBridge: MainActivityBridge

    private val presenter by lazy {
        ListCocktailPresenter(CocktailClass.getApp(context))
    }

    private val mAdapter by lazy {
        CocktailAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivityBridge = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_cocktails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        recyclerView.adapter = mAdapter
        presenter.fetch()

    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_list_cocktail, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnFilter -> {
                mainActivityBridge.navController()
                    .navigate(R.id.action_listCocktailsFragment_to_filtersFragment)
            }
        }
        return super.onOptionsItemSelected(item)

    }

    override fun showList(list: List<DataCocktails>) {
        mAdapter.setData(list)
    }
}