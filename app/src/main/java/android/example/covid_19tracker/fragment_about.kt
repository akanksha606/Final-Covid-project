package android.example.covid_19tracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_about.*


class fragment_about : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        api_link.setOnClickListener() {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://api.covid19india.org/data.json"))
            startActivity(intent)
        }
        code.setOnClickListener(){
            val intent2 = Intent(Intent.ACTION_VIEW)
            intent2.setData(Uri.parse("https://github.com/akanksha606/CovidProject"))
            startActivity(intent2)
        }

    }
}
