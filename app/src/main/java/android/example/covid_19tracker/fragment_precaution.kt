package android.example.covid_19tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_precaution.*


class fragment_precaution : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_precaution, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrayList=ArrayList<Model>()

        arrayList.add(Model("Wear a cloth face mask","Don’t touch your eyes, nose or mouth.",R.drawable.mask))
        arrayList.add(Model("Avoid Traveling","This will avoid close contact",R.drawable.travel))
        arrayList.add(Model("Stay Home","Maintain social distance ,stay safe",R.drawable.reading_a_book))
        arrayList.add(Model("Maintain distance","Maintain a safe distance from anyone who is coughing or sneezing",R.drawable.distance))
        arrayList.add(Model("Stay home if you feel unwell","Cover your cough or sneeze with a tissue, then throw the tissue in the trash.",R.drawable.sick))
        arrayList.add(Model("Clean your hands often.","Use soap and water, or an alcohol-based hand rub.",R.drawable.washing_hands))
        val myAdapter=MyAdapter(arrayList,this)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        recyclerView.adapter=myAdapter
    }
}



