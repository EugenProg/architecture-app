package kz.just_code.architectureapp.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.architectureapp.FaqAdapter
import kz.just_code.architectureapp.databinding.FaqListFragmentBinding
import kz.just_code.architectureapp.repository.FaqRepository
import kz.just_code.architectureapp.repository.FaqRepositoryImpl

class FaqMvvmFragment : Fragment() {
    private lateinit var binding: FaqListFragmentBinding
    private val adapter: FaqAdapter = FaqAdapter()
    private val viewModel: FaqViewModel = FaqViewModel(FaqRepositoryImpl())

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

        viewModel.getData()
        binding.listView.layoutManager = LinearLayoutManager(requireContext())
        binding.listView.adapter = adapter

        adapter.click = {
            //findNavController().navigate()
        }

        viewModel.faqListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}