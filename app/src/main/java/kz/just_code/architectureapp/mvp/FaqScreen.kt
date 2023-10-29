package kz.just_code.architectureapp.mvp

import kz.just_code.architectureapp.repository.Faq

sealed interface FaqScreen {
    interface View {
        fun showMessage(message: String)
        fun showData(list: List<Faq>)
    }

    interface Presenter {
        fun getData()
        fun openDetails(faq: Faq)
    }
}