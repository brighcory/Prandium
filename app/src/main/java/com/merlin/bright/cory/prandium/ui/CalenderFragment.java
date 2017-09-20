package com.merlin.bright.cory.prandium.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merlin.bright.cory.prandium.R;

/**
 * Created by cory on 7/20/17.
 */

public class CalenderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

//        OnCalenderSelected listener = (OnCalenderSelected) getActivity();
        View view = inflater.inflate(R.layout.fragment_calender, container, false);

        return view;
    }

    public interface OnCalenderSelected {
        void onDateSelectedSelected(int index);
    }
}
