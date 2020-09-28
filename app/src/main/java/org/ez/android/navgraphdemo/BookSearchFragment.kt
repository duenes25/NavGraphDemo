package org.ez.android.navgraphdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_book_search.*
import kotlinx.android.synthetic.main.fragment_book_search.view.*

class BookSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_search, container, false)
        view.detailsButton.setOnClickListener {

            findNavController().navigate(R.id.actionBookDetails)

        }


        return view
    }


}