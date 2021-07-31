package com.example.accident_app.Fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.accident_app.R
import com.example.accident_app.interfaces.IEmergency

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EmergenciesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmergenciesFragment : Fragment() {

    lateinit var listener: IEmergency;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is IEmergency){
            listener = context;
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_emergencies, container, false);
        val call_emergency = view.findViewById<CardView>(R.id.id_call_emergency);
        val call_national_police = view.findViewById<CardView>(R.id.id_nacional_police);
        val call_defence_civil = view.findViewById<CardView>(R.id.id_call_defence);
        val call_red_cross = view.findViewById<CardView>(R.id.id_call_red);

        call_emergency.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:911")
            }
                startActivity(intent)
            //Toast.makeText(context,"Telefono"+ intent, Toast.LENGTH_LONG).show()
        }
//
//        call_national_police.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL).apply{
//                data = Uri.parse("tel:(809) 682-2151")
//            }
//            startActivity(intent)
//        }
//
//        call_defence_civil.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL).apply{
//                data = Uri.parse("tel:(809) 472-4614")
//            }
//            startActivity(intent)
//        }
//
//        call_red_cross.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL).apply{
//                data = Uri.parse("tel:(809) 334-4545")
//            }
//            startActivity(intent)
//        }
        return view;
    }


    companion object {
    }
}