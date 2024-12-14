package com.example.sliderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

class WebViewFragment : Fragment() {

    companion object {
        private const val ARG_PAGE = "arg_page"

        fun newInstance(page: Page): WebViewFragment {
            val fragment = WebViewFragment()
            val args = Bundle()
            args.putSerializable(ARG_PAGE, page)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = view.findViewById<WebView>(R.id.webView)
        val page = arguments?.getSerializable(ARG_PAGE) as? Page

        webView.webViewClient = WebViewClient() // Для открытия страниц внутри приложения
        webView.settings.javaScriptEnabled = true // Включаем поддержку JavaScript
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT

        page?.let {
            webView.loadUrl(it.url)
        }
    }
}