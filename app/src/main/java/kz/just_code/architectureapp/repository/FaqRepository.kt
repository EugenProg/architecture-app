package kz.just_code.architectureapp.repository

interface FaqRepository {
    fun getFaqList(): List<Faq>
}