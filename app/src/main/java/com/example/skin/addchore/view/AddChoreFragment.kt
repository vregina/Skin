package com.example.skin.addchore.view

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.skin.R
import com.example.skin.addchore.presenter.AddChoreFragmentPresenter
import com.example.skin.home.view.Tarefa
import java.text.SimpleDateFormat
import java.util.*
import android.graphics.drawable.Drawable as Drawable1

class AddChoreFragment : Fragment() {

    lateinit var presenter: AddChoreFragmentPresenter
    lateinit var btSelectClock: LinearLayout
    lateinit var tvTimer: TextView
    lateinit var spProductType: Spinner
    lateinit var btMonday: Button
    lateinit var btTuesday: Button
    lateinit var btWednesday: Button
    lateinit var btThursday: Button
    lateinit var btFriday: Button
    lateinit var btSaturday: Button
    lateinit var btSunday: Button
    lateinit var bcOrange: Drawable1
    lateinit var btFinish: Button
    lateinit var productName: EditText
    private val cal = Calendar.getInstance()
    lateinit var timerPickerDialog: TimePickerDialog
    lateinit var timeSetListener: TimePickerDialog.OnTimeSetListener

//    lateinit var timePicker: TimePicker


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AddChoreFragmentPresenter(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_chore, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            timerPickerDialog.updateTime(
                hour,
                minute
            )

            tvTimer.text = SimpleDateFormat("HH:mm").format(cal.time)

            presenter.setChoreTime(cal.time.toString())
        }

        timerPickerDialog = TimePickerDialog(
            context,
            timeSetListener,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            true
        )

        activity?.let {
            btSelectClock = it.findViewById<LinearLayout>(R.id.bt_clock)
            tvTimer = it.findViewById<TextView>(R.id.tv_timer)
            spProductType = it.findViewById<Spinner>(R.id.sp_product_type)
            btMonday = it.findViewById<Button>(R.id.bt_monday)
            btTuesday = it.findViewById<Button>(R.id.bt_tuesday)
            btWednesday = it.findViewById<Button>(R.id.bt_wednesday)
            btThursday = it.findViewById<Button>(R.id.bt_thursday)
            btFriday = it.findViewById<Button>(R.id.bt_friday)
            btSaturday = it.findViewById<Button>(R.id.bt_saturday)
            btSunday = it.findViewById<Button>(R.id.bt_sunday)
            btFinish = it.findViewById<Button>(R.id.bt_finish)
            productName = it.findViewById<EditText>(R.id.et_product_type)
        }

        btSelectClock.setOnClickListener {
            timerPickerDialog.show()
        }

        val productType = listOf("Tipo de Tratamento", "Hidratação", "Proteção solar", "Limpeza")
        spProductType.adapter = activity?.baseContext?.let {
            SpinnerAdapter(
                productType,
                it,
                android.R.layout.simple_list_item_1
            )
        }

        spProductType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                var x = 1
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                presenter.setChoreType(parent?.getItemAtPosition(position).toString())
            }
        }

        btMonday.setOnClickListener {
            btMonday.isSelected = !btMonday.isSelected
        }

        btTuesday.setOnClickListener {
            btTuesday.isSelected = !btTuesday.isSelected
        }

        btWednesday.setOnClickListener {
            btWednesday.isSelected = !btWednesday.isSelected
        }

        btThursday.setOnClickListener {
            btThursday.isSelected = !btThursday.isSelected
        }

        btFriday.setOnClickListener {
            btFriday.isSelected = !btFriday.isSelected
        }

        btSaturday.setOnClickListener {
            btSaturday.isSelected = !btSaturday.isSelected
        }

        btSunday.setOnClickListener {
            btSunday.isSelected = !btSunday.isSelected
        }

        btFinish.setOnClickListener {
            presenter.setChoreName(productName.text.toString())
//            Toast.makeText(view?.context, "Tarefa adicionada!", Toast.LENGTH_LONG).show()
        }


//        btTuesday.setOnClickListener {
//            btTuesday.setBackgroundDrawable(resources.getDrawable(R.drawable.bt_orange_shape))
//        }
    }

    fun terminaERetorna(chore: Tarefa) {
        (activity as AddChoreActivity).termina(chore)
    }


}


//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment fragment_add_chore.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            fragment_add_chore().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
