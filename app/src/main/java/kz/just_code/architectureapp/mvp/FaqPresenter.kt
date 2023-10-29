package kz.just_code.architectureapp.mvp

import kz.just_code.architectureapp.repository.Faq
import kz.just_code.architectureapp.repository.FaqRepository
import kz.just_code.architectureapp.repository.FaqRepositoryImpl

class FaqPresenter(
    private val view: FaqScreen.View
) : FaqScreen.Presenter {
    private val repository: FaqRepository = FaqRepositoryImpl()

    override fun getData() {
        val data = repository.getFaqList()
        view.showData(data)
    }

    override fun openDetails(faq: Faq) {
        view.showMessage(faq.description.toString())
    }
}