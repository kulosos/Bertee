package de.kularts.bertee.Controller;

import android.content.Context;
import android.util.Log;

import de.kularts.bertee.Model.WorktimeEntry;
import de.kularts.bertee.Model.WorktimeEntryType;
import de.kularts.bertee.R;

/**
 * WorkTimeController is the central class,
 * which controls all communication between
 * model and view.
 *
 * @author Oliver Kulas (http://www.oliverkulas.de)
 * @verion 1.0
 * @since 2016-01-24
 */

public class WorkTimeController {

    private static WorkTimeController instance;
    private Context context;

    // DEBUG
    private static final String TAG = MainActivity.class.getName();
    private static final boolean D = false;

    // ------------------------------------------------------------------------

    public WorkTimeController(Context context){
        this.context = context;
    }

    // SINGLETON
    public static void initInstance(Context context){
        if(instance == null){
            instance = new WorkTimeController(context);
        }
    }

    public static WorkTimeController instance(){
        return instance;
    }

    // ------------------------------------------------------------------------

    public void createWorkTimeEntry(WorktimeEntryType type){

        WorktimeEntry wt = new WorktimeEntry(type);

        Log.d(TAG, "WT ENTRY time: " + wt.getType());
        Log.d(TAG, "WT ENTRY type: " + wt.getTimestamp());

        new CustomToast(this.context, "this is a toast msg", R.drawable.ic_getin, 700);
    }

}
