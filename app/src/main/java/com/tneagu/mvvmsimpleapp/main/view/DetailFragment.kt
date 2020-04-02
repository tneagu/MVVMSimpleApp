package com.tneagu.mvvmsimpleapp.main.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tneagu.mvvmsimpleapp.R
import com.tneagu.mvvmsimpleapp.databinding.FragmentDetailBinding
import com.tneagu.mvvmsimpleapp.main.util.getProgressDrawable
import com.tneagu.mvvmsimpleapp.main.util.loadImage
import com.tneagu.mvvmsimpleapp.main.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    private var dogUuid = 0
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        );
        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            dogUuid = DetailFragmentArgs.fromBundle(it).dogUuid
        }

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch(dogUuid)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dogLiveData.observe(this, Observer { dog ->
            dog?.let {
                dataBinding.dog = dog
            }
        })
    }
}
