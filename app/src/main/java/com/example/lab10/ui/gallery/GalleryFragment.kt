package com.example.lab10.ui.gallery
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.example.lab10.databinding.FragmentGalleryBinding // Adjusted import

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding // Adjusted binding variable
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false) // Adjusted binding inflation
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = binding.viewPager
        tabs = binding.tabLayout

        // Initialize tabs
        setupTabs()

        // Show a Snackbar
        showSnackbar()
    }

    private fun setupTabs() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(FirstFragment(), "Support")
        adapter.addFragment(SecondFragment(), "FAQ")

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)

        // Add a listener to handle tab selection and animate ViewPager
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // No action needed
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // No action needed
            }
        })
    }

    private fun showSnackbar() {
        val snackbar = Snackbar.make(requireView(), "This is a Snackbar", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Dismiss") {
            snackbar.dismiss() // Dismiss the snackbar when action is clicked
        }
        snackbar.show()
    }
}

