import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text

    fun changeText() {
        _text.value = "Sanzhar!"
    }
    fun previousText() {
        _text.value = "Kairliev"
    }
}
