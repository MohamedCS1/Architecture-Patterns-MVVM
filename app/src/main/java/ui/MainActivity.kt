package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movies_nerds.R
import pojo.Model_Movies

class MainActivity : AppCompatActivity(),View.OnClickListener{
    var movieViewModel:MovieViewModel? = null

    var Tv_Title: TextView? = null
    var Tv_Date_Publication:TextView? = null
    var Tv_Print_Lenght:TextView? = null
    var Tv_Language:TextView? = null
    var bu_Display_Data:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Tv_Title =  findViewById<TextView>(R.id.Tv_Title)
        Tv_Date_Publication = findViewById<TextView>(R.id.Tv_Date_Publication)
        Tv_Print_Lenght = findViewById<TextView>(R.id.Tv_Print_Lenght)
        Tv_Language = findViewById<TextView>(R.id.Tv_Language)
        bu_Display_Data = findViewById<Button>(R.id.bu_Display_Data)
        bu_Display_Data!!.setOnClickListener(this)

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        movieViewModel!!.movie_mutable_live_data.observe(this,object :Observer<Model_Movies>{
            override fun onChanged(t: Model_Movies?) {
                Tv_Title!!.text = t!!.Title.toString()
                Tv_Date_Publication!!.text = t.Date_Publication.toString()
                Tv_Print_Lenght!!.text = t.Print_Lenght.toString()
                Tv_Language!!.text = t.Language.toString()
            }
        })
    }

    override fun onClick(v: View?) {
        if (v!!.id == bu_Display_Data!!.id)
        {
            movieViewModel?.get_movie_data()
        }
    }
}