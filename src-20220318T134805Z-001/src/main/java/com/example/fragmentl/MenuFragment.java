package com.example.fragmentl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        String[] menu = getResources().getStringArray(R.array.menu);

        ListView listView = view.findViewById(R.id.myListView);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.listview_item, menu));
        listView.setOnItemClickListener((adapterView, view1, i, l) -> {
            ContentFragment contentFragment = (ContentFragment) getParentFragmentManager().findFragmentById(R.id.contentFragment);
            contentFragment.updateFrag(i);
        });
        return view;
    }
}
