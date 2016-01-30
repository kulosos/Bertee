package de.kularts.bertee.Controller;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import de.kularts.bertee.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}