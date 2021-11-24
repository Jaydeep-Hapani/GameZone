package jaydeep.project.gamezone

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class SettingsDialogFragment
/**
 * Instantiates a new settings dialog fragment.
 *
 * @param size
 * the size
 */(
    /** The size.  */
    var size: Int
) : DialogFragment() {
    /**
     * Gets the size.
     *
     * @return the size
     */
    /**
     * Sets the size.
     *
     * @param size
     * the new size
     */

    /*
     * (non-Javadoc)
     *
     * @see
     * android.support.v4.app.DialogFragment#onCreateDialog(android.os.Bundle
     * )
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        // Set the dialog title
        builder.setTitle("Define the size of the puzzle")
            .setSingleChoiceItems(
                R.array.size_options, size - 2
            ) { dialog, which -> size = which + 2 }
            .setPositiveButton(
                "Change"
            ) { dialog, id ->
                (getActivity() as NumberPulzz)
                    .changeSize(size)
            }
            .setNegativeButton(
                "Cancel"
            ) { dialog, id -> dialog.cancel() }
        val settingsDialog =  builder.create()
        settingsDialog.show()
        return  settingsDialog
    }
}