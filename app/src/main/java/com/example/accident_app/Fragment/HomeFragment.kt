package com.example.accident_app.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.accident_app.R
import com.example.accident_app.interfaces.IComunicationFragment
import com.example.accident_app.ui.MapActivity
import com.mapbox.mapboxsdk.maps.MapFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var listener : IComunicationFragment;
    lateinit var id_publish:CardView;
    lateinit var id_map: CardView;
    lateinit var id_emergency:CardView;
    lateinit var id_report:CardView;
    lateinit var id_help :CardView;
    lateinit var id_config:CardView;
    override fun onCreate(savedInstanceState: Bundle?) {
        val context: Context;

        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as IComunicationFragment
        val activity = activity as Context
        if(context is IComunicationFragment){
            listener = context;
        }
    }

   public override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

         id_publish = view.findViewById<CardView>(R.id.id_published);
         id_map = view.findViewById<CardView>(R.id.id_map);
         id_emergency = view.findViewById<CardView>(R.id.id_emergency);
         id_report = view.findViewById<CardView>(R.id.id_report);
         id_help = view.findViewById<CardView>(R.id.id_help);
         id_config = view.findViewById<CardView>(R.id.id_configuration);
          menu();

        // Inflate the layout for this fragment
        return view;
    }


    fun menu(){
        id_publish.setOnClickListener{
            listener.publishAccident(PublishFragment());
        }

        id_map.setOnClickListener{
            listener.getMap(MapActivity());
        }

        id_emergency.setOnClickListener{
            listener.numberEmergency(EmergenciesFragment());
        }

        id_report.setOnClickListener{
            Toast.makeText(context,"Report", Toast.LENGTH_LONG).show();
        }

        id_help.setOnClickListener {
            Toast.makeText(context, "Help user", Toast.LENGTH_LONG).show();
        }
        id_config.setOnClickListener {
            listener.configurationUser(SettingFragment());
        }
    }
}