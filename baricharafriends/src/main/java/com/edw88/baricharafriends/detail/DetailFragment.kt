package com.edw88.baricharafriends.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.edw88.baricharafriends.databinding.FragmentDetailBinding
import com.edw88.baricharafriends.main.MainActivity


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sitios = args.sitio


        with(detailBinding) {
            cementerioTextView.text = sitios.nombre
            cementerioDescripcionTextView.text = sitios.descripcionlarga
            com.squareup.picasso.Picasso.get().load(sitios.urlFoto).into(imageView5)
        }

    }
}




