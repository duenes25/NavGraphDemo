package org.ez.android.navgraphdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_book_search.*
import kotlinx.android.synthetic.main.fragment_book_search.view.*
import androidx.databinding.DataBindingUtil
import org.ez.android.navgraphdemo.databinding.FragmentBookSearchBinding

class BookSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /**
        **Remove this for Compose Migration
        **
        val view = inflater.inflate(R.layout.fragment_book_search, container, false)


        view.detailsButton.setOnClickListener {

            findNavController().navigate(R.id.actionBookDetails)

        }
        return view
*/

        /**
         * Add this for compose
         */
        val binding = DataBindingUtil.inflate<FragmentBookSearchBinding>(
            inflater, R.layout.fragment_book_search, container, false
        ).apply {
            composeView.setContent {
                MaterialTheme {
                    BookSearchDescription(onNavClick = {onNavClick()})
                }
            }
        }
        return binding.root

    }


    private fun onNavClick(){
        findNavController().navigate(R.id.actionBookDetails)
    }

}