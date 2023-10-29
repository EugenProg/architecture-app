package kz.just_code.architectureapp.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.architectureapp.FaqAdapter
import kz.just_code.architectureapp.databinding.FaqListFragmentBinding
import kz.just_code.architectureapp.repository.Faq

class FaqMvpFragment: Fragment(), FaqScreen.View {
    private lateinit var binding: FaqListFragmentBinding
    private val adapter: FaqAdapter = FaqAdapter()
    private lateinit var presenter: FaqScreen.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FaqListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FaqPresenter(this)
        presenter.getData()

        binding.listView.layoutManager = LinearLayoutManager(requireContext())
        binding.listView.adapter = adapter

        adapter.click = {
            presenter.openDetails(it)
            //findNavController().navigate()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showData(list: List<Faq>) {
        adapter.submitList(list)
    }
}