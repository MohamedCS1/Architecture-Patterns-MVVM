package ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pojo.Model_Movies

class MovieViewModel: ViewModel() {

    val movie_mutable_live_data = MutableLiveData<Model_Movies>()

    private fun get_Data_From_Model(): Model_Movies {
        return Model_Movies("Straus and Giroux", "June 1,1999", 256, "English")
    }

    fun get_movie_data()
    {
        movie_mutable_live_data.value =  get_Data_From_Model()
    }


}