package com.broersen.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_portals.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalsFragment : Fragment() {
    private val portals = arrayListOf<Portal>()
    private val portalAdapter: PortalAdapter = PortalAdapter(portals)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        ObserveAddPortal()
    }

    private fun ObserveAddPortal() {
        setFragmentResultListener(REQ_PORTAl_KEY) {resultKey, bundle -> bundle.getParcelable<Portal>(
            BUNDLE_PORTAL_KEY)?.let {
            portals.add(it)
            portalAdapter.notifyDataSetChanged()
        } }
    }

    private fun initViews() {
        rvPortals.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rvPortals.adapter = portalAdapter
    }


}