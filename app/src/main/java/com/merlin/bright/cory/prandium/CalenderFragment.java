package com.merlin.bright.cory.prandium;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cory on 7/20/17.
 */

public class CalenderFragment extends Fragment {

    public interface OnDateSelectedInterface {
        void onDateSelectedSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        CalenderFragment.OnDateSelectedInterface listener = (OnDateSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_calender, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.calenderRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
