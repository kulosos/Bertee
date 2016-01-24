package de.kularts.bertee.Controller;

import android.content.Context;
import android.util.Log;
import de.kularts.bertee.Model.WorkTimeDatabase;

public class DatabaseController {

    private static DatabaseController instance;

    // Databases
    private WorkTimeDatabase worktimeDB;

    // DEBUG
    private static final boolean D = false;

    // ------------------------------------------------------------------------

    private DatabaseController(Context context) {

        worktimeDB = new WorkTimeDatabase(context);
    }

    // SINGLETON METHODS

    public static void initInstance(Context context){
        if(instance == null){
            instance = new DatabaseController(context);
        }
    }

    public static DatabaseController instance(){
        return instance;
    }


}

