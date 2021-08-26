package com.example.accident_app.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.accident_app.R
import com.example.accident_app.interfaces.IComunicationFragment
import com.example.accident_app.interfaces.ISetting

class SettingFragment : Fragment() {

    private lateinit var setting: ISetting;
    private lateinit var general_configuration: CardView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setting = context as ISetting
        if(context is ISetting)
            setting = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_setting, container, false)

         general_configuration = view.findViewById<CardView>(R.id.id_general_configuration);
        option();
        return view;
    }

    fun option(){
        general_configuration.setOnClickListener {
            setting.settingConfiguration(GeneralConfigurationFragment());
        }
    }
}