package com.hijacker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import static com.hijacker.MainActivity.load;
import static com.hijacker.MainActivity.pref_edit;

public class ConfirmResetDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.reset_dialog_title);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                pref_edit.putString("iface", getString(R.string.iface));
                pref_edit.putString("prefix", getString(R.string.prefix));
                pref_edit.putString("aircrack_dir", getString(R.string.aircrack_dir));
                pref_edit.putString("airodump_dir", getString(R.string.airodump_dir));
                pref_edit.putString("aireplay_dir", getString(R.string.aireplay_dir));
                pref_edit.putString("mdk3_dir", getString(R.string.mdk3_dir));
                pref_edit.putString("cap_dir", getString(R.string.cap_dir));
                pref_edit.putString("enable_monMode", getString(R.string.enable_monMode));
                pref_edit.putString("disable_monMode", getString(R.string.disable_monMode));
                pref_edit.putString("deauthWait", getString(R.string.deauthWait));
                pref_edit.putString("aireplay_sleep", getString(R.string.aireplay_sleep));
                pref_edit.putBoolean("showLog", Boolean.parseBoolean(getString(R.string.showLog)));
                pref_edit.putBoolean("show_notif", Boolean.parseBoolean(getString(R.string.show_notif)));
                pref_edit.putBoolean("show_details", Boolean.parseBoolean(getString(R.string.show_details)));
                pref_edit.putBoolean("airOnStartup", Boolean.parseBoolean(getString(R.string.airOnStartup)));
                pref_edit.putBoolean("debug", Boolean.parseBoolean(getString(R.string.debug)));
                pref_edit.putBoolean("confirm_exit", Boolean.parseBoolean(getString(R.string.confirm_exit)));
                pref_edit.putBoolean("delete_extra", Boolean.parseBoolean(getString(R.string.delete_extra)));
                pref_edit.commit();
                load();
                dismiss();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //return
            }
        });
        return builder.create();
    }
}
