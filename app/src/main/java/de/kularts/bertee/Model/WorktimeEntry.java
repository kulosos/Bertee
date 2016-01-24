/**
 * WorktimeEntry class represents a pure data object
 * without explicit funtions. Objects of this class
 * will used for saving in persistant database.
 *
 * @author Oliver Kulas (http://www.oliverkulas.de)
 * @verion 1.0
 * @since 2016-01-24
 */

package de.kularts.bertee.Model;

import java.util.Date;
import de.kularts.bertee.Controller.MainActivity;


public class WorktimeEntry {

    private int id;
    private Date timestamp;
    private WorktimeEntryType type;

    // DEBUG
    private static final String TAG = MainActivity.class.getName();
    private static final boolean D = false;

    // ------------------------------------------------------------------------

    public WorktimeEntry(WorktimeEntryType type){

        //this.id = id; // AutoIncrement by database
        this.timestamp = new java.util.Date();
        this.type = type;
    }

    public WorktimeEntry(Date timestamp, WorktimeEntryType type){

        this.timestamp = timestamp;
        this.type = type;
    }

    // ------------------------------------------------------------------------

    public String toString(){
        return "[id=" + this.id + ", " + this.timestamp + ", " + this.type + "]";
    }

    // SETTER / GETTER --------------------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setType(WorktimeEntryType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public WorktimeEntryType getType() {
        return type;
    }
}
