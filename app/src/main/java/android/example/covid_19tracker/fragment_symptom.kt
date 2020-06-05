package android.example.covid_19tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_symptom.*


class fragment_symptom : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_symptom, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrayList=ArrayList<Model>()
        arrayList.add(Model("Dry Cough","Several days of having a dry cough",R.drawable.cough))
        arrayList.add(Model("Fever","Having a high fever",R.drawable.fever))
        arrayList.add(Model("Headache","Having a severe headache",R.drawable.headache))
        arrayList.add(Model("Runny Nose","Having a runny nose",R.drawable.runny))
        arrayList.add(Model("Vomiting","Continuous vomiting",R.drawable.vomitting))
        arrayList.add(Model("Sore Throat","Having a sore throat since long",R.drawable.throat))
        val myAdapter=MyAdapterSymptoms(arrayList,this)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        recyclerView.adapter=myAdapter
    }


    }
