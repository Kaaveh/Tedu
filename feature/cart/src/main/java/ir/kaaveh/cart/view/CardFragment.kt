package ir.kaaveh.cart.view

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.phelat.tedu.androiddagger.inject
import com.phelat.tedu.lifecycle.ViewModelFactory
import ir.kaaveh.cart.R
import ir.kaaveh.cart.di.component.CardComponent
import ir.kaaveh.cart.viewmodel.CardViewModel
import javax.inject.Inject

class CardFragment : Fragment(R.layout.fragment_card) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CardViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject<CardComponent>()
    }
}