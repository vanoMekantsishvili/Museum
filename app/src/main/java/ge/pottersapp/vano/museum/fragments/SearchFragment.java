package ge.pottersapp.vano.museum.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ge.pottersapp.vano.museum.R;

/**
 * Created by vano on 4/25/2016.
 */
public class SearchFragment extends Fragment {
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.search, container, false);
    }
}
