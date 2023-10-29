package kz.just_code.architectureapp.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.just_code.architectureapp.repository.Faq
import kz.just_code.architectureapp.repository.FaqRepository

class FaqViewModel(
    private var repository: FaqRepository
): ViewModel() {

    private var _faqListLiveData = MutableLiveData<List<Faq>>()
    var faqListLiveData: LiveData<List<Faq>> = _faqListLiveData

    fun getData() {
        val data = repository.getFaqList()
        _faqListLiveData.postValue(data)
    }
}