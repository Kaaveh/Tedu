package ir.kaaveh.cart.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.phelat.tedu.androiddagger.inject
import com.phelat.tedu.lifecycle.ViewModelFactory
import ir.kaaveh.cart.R
import ir.kaaveh.cart.databinding.FragmentCardBinding
import ir.kaaveh.cart.di.component.CardComponent
import ir.kaaveh.cart.utils.viewLifecycleLazy
import ir.kaaveh.cart.viewmodel.CardViewModel
import javax.inject.Inject

class CardFragment : Fragment(R.layout.fragment_card) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CardViewModel by viewModels { viewModelFactory }
    private val binding by viewLifecycleLazy { FragmentCardBinding.bind(requireView()) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject<CardComponent>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shopCard.observe(viewLifecycleOwner) { shopCard ->
            binding.txtShopCard.text = shopCard.toString()
        }
    }
}