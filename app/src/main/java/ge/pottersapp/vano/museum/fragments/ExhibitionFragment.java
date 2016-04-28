package ge.pottersapp.vano.museum.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ge.pottersapp.vano.museum.ExhibitionData;
import ge.pottersapp.vano.museum.ExhibitionObject;
import ge.pottersapp.vano.museum.R;
import ge.pottersapp.vano.museum.RecyclerViewAdapter;

/**
 * Created by vano on 4/25/2016.
 */
public class ExhibitionFragment extends Fragment {
    private RecyclerView rv;
    private LinearLayoutManager mLayoutManager;
    private RecyclerViewAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.exhibition, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.exhibition_recycler_view);
        ArrayList<ExhibitionObject> exhibitions = new ArrayList<>();
        for(int i=0;i< ExhibitionData.titles.length;i++)
        {
            ExhibitionObject exhibition = new ExhibitionObject(ExhibitionData.titles[i],ExhibitionData.images[i],ExhibitionData.links[i]);
            exhibitions.add(exhibition);
        }

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(exhibitions);
        rv.setAdapter(mAdapter);


        return rootView;
    }


}
