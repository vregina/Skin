package com.example.skin.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.skin.R
import com.example.skin.home.presenter.HomeFragmentPresenter
import com.example.skin.register.presenter.RegisterFragmentPresenter


class RegisterFragment : Fragment() {

    lateinit var presenter: RegisterFragmentPresenter
    lateinit var buttonContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = RegisterFragmentPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = RegisterFragmentPresenter(this)
    }

//        val buttonContinue = view?.findViewById<Button>(R.id.bt_continue_register)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //INICIALIZAR TODOS OS COMPONENTES
        activity?.let {
            buttonContinue = it.findViewById<Button>(R.id.bt_continue_register)
        }

        buttonContinue.setOnClickListener { v ->
            (activity as? RegisterActivity)?.showRegisterSkinToneFragment()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterSkinTypeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {


                }
            }
    }
}

