package de.kularts.bertee.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;

import de.kularts.bertee.Controller.MainActivity;
import de.kularts.bertee.Controller.TypefaceController;
import de.kularts.bertee.Controller.TypefaceWeight;
import de.kularts.bertee.Controller.WorkTimeController;
import de.kularts.bertee.Model.WorktimeEntryType;
import de.kularts.bertee.R;


public class WorkTimeFragment extends Fragment implements View.OnClickListener {

    // Buttons
    private View btn_getin;
    private View btn_getout;

    // Text
    private View txt_worktimestatus;

    // DEBUG
    private static final String TAG = MainActivity.class.getName();
    private static final boolean D = false;

    // ------------------------------------------------------------------------

    public WorkTimeFragment() {
        // Required empty public constructor
    }

    // Interface Implementation -----------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_work_time, container, false);

        TextClock txtClock = (TextClock) view.findViewById(R.id.textClock);
        txtClock.setTypeface(TypefaceController.instance().getTypeface(TypefaceWeight.Light));

        // Get text status line
        this.txt_worktimestatus = (View)view.findViewById(R.id.txt_worktimestatus);

        // Set OnClickListeners
        this.btn_getin = (View)view.findViewById(R.id.btn_getin_container);
        btn_getin.setOnClickListener(this);

        this.btn_getout = (View)view.findViewById(R.id.btn_getout_container);
        btn_getout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getin_container:
                Log.d(TAG, "Get IN Button");
                WorkTimeController.instance().createWorkTimeEntry(WorktimeEntryType.GetIn);
                break;
            case R.id.btn_getout_container:
                Log.d(TAG, "Get OUT Button");
                break;
        }
    }

    // ------------------------------------------------------------------------
}
