package android.example.covid_19tracker

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class fragment_home : Fragment() {
    lateinit var stateAdapter: StateAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

            return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchResults()
    }

    private fun fetchResults() {
    GlobalScope.launch {
     val response= withContext(Dispatchers.IO){Client.api.clone().execute() }
     if(response.isSuccessful){
     val data= Gson().fromJson(response.body?.string(),Response::class.java)
         launch(Dispatchers.Main) {
             bindCombinedData(data.statewise[0])
             bindStateWiseData(data.statewise.subList(1,data.statewise.size))
         }
     }
    }
    }

    private fun bindStateWiseData(subList: List<StatewiseItem>) {
        stateAdapter=StateAdapter(subList)
        list.adapter=stateAdapter

    }

    private fun bindCombinedData(data: StatewiseItem) {
     val lastUpdatedTime=data.lastupdatedtime
        val simpleDateFormat=SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        lastUpdatedTv.text="Last Updated :  ${getTimeAgo(simpleDateFormat.parse(lastUpdatedTime))}"
        confirmedTv.text=data.confirmed
        activeTv.text=data.active
        recoveredTv.text=data.recovered
        deceasedTv.text=data.deaths

    }


    private fun getTimeAgo(past: Date): String {
        val now =Date()
        val seconds= TimeUnit.MILLISECONDS.toSeconds(now.time-past.time)
        val minutes= TimeUnit.MILLISECONDS.toSeconds(now.time-past.time)
        val hours= TimeUnit.MILLISECONDS.toSeconds(now.time-past.time)
        return when{
            seconds<60->{
                "Few Seconds ago"
            }
            minutes<60->{
                "$minutes minutes ago"
            }
            hours<60->{
                "$hours hour ${minutes%60} min ago"
            }
            else->{
                SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(past).toString()
            }
        }

    }

}

