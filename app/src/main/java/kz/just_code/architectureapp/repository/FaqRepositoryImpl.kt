package kz.just_code.architectureapp.repository

import kz.just_code.architectureapp.R

class FaqRepositoryImpl : FaqRepository {
    private var faqList: List<Faq> = listOf()

    override fun getFaqList(): List<Faq> {
        return faqList.ifEmpty { getRemoteFaq() }
    }

    private fun getRemoteFaq(): List<Faq> {
        val list: MutableList<Faq> = mutableListOf(
            Faq(0, R.string.title_1, R.string.description),
            Faq(1, R.string.title_2, R.string.description),
            Faq(2, R.string.title_3, R.string.description),
            Faq(3, R.string.title_4, R.string.description),
            Faq(4, R.string.title_5, R.string.description),
            Faq(5, R.string.title_6, R.string.description)
        )

        faqList = list

        return list
    }
}