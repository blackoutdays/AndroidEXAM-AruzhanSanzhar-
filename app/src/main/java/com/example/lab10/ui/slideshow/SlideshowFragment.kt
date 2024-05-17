package com.example.lab10.ui.slideshow

import SlideshowViewModel
import android.provider.Settings
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab10.databinding.FragmentSlideshowBinding
import androidx.constraintlayout.widget.ConstraintLayout
import android.graphics.Color
import android.widget.Switch
import android.content.Intent
import com.example.lab10.AboutUsActivity
import com.example.lab10.LanguageSettingsActivity
import com.example.lab10.PrivacySecurityActivity


class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val constraintLayout = binding.container
        val switchNightMode = binding.switchNightMode
        val languageLayout = binding.languageLayout
        val aboutUsLayout = binding.aboutUsLayout
        val securityPrivacyLayout = binding.securityPrivacyLayout

        switchNightMode.setOnCheckedChangeListener { _, isChecked ->
            SharedPreferenceManager.setNightModeEnabled(isChecked, requireContext())
            updateBackground(isChecked, constraintLayout)
        }

        val isNightModeEnabled = SharedPreferenceManager.isNightModeEnabled(requireContext())
        updateBackground(isNightModeEnabled, constraintLayout)

        languageLayout.setOnClickListener {
            startActivity(Intent(requireContext(), LanguageSettingsActivity::class.java))
        }

        aboutUsLayout.setOnClickListener {
            startActivity(Intent(requireContext(), AboutUsActivity::class.java))
        }

        securityPrivacyLayout.setOnClickListener {
            val intent = Intent(Settings.ACTION_PRIVACY_SETTINGS)
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(intent)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateBackground(isNightModeEnabled: Boolean, constraintLayout: ConstraintLayout) {
        val backgroundColor = if (isNightModeEnabled) {
            Color.CYAN // Change to your desired dark background color
        } else {
            Color.WHITE // Change to your desired default background color
        }
        constraintLayout.setBackgroundColor(backgroundColor)
    }
}
