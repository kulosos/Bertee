package de.kularts.bertee.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;

import de.kularts.bertee.Controller.MainActivity;
import de.kularts.bertee.Controller.TypefaceController;
import de.kularts.bertee.Controller.TypefaceWeight;
import de.kularts.bertee.R;


public class WorkTimeFragment extends Fragment {

    public WorkTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_work_time, container, false);

        TextClock txtClock = (TextClock) view.findViewById(R.id.textClock);
        txtClock.setTypeface(TypefaceController.getInstance().getTypeface(TypefaceWeight.Light));

        // instantiate PlaylistController Singleton
        //PlaylistController.initInstance(this, getActivity());

        // get list from fragment
        //playlistView = (ListView)view.findViewById(R.id.playlistView);

        //PlaylistController.getInstance().initPlaylist();

        return view;
    }

    // ------------------------------------------------------------------------

    @Override
    public void onResume(){
        super.onResume();
    }

    // ------------------------------------------------------------------------

    @Override
    public void onPause(){
        super.onPause();
    }

}
