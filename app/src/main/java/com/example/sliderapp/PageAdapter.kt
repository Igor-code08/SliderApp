package com.example.sliderapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(
    fragmentActivity: FragmentActivity,
    private val pages: List<Page>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment {
        return WebViewFragment.newInstance(pages[position])
    }
}