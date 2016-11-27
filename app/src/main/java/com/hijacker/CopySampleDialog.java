package com.hijacker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import static com.hijacker.MainActivity.aircrack_dir;
import static com.hijacker.MainActivity.aireplay_dir;
import static com.hijacker.MainActivity.airodump_dir;
import static com.hijacker.MainActivity.cap_dir;
import static com.hijacker.MainActivity.copy;
import static com.hijacker.MainActivity.iface;
import static com.hijacker.MainActivity.mdk3_dir;
import static com.hijacker.MainActivity.prefix;

public class CopySampleDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.copy_sample_title);
        builder.setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //return
            }
        });
        builder.setItems(R.array.test_cmd, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0:
                        copy(aircrack_dir + " " + cap_dir + "/wpa.cap-01.cap", getView());
                        break;
                    case 1:
                        copy(prefix + " " + airodump_dir + " --update 1 --channel 2 --bssid 00:11:22:33:44:55 " + iface, getView());
                        break;
                    case 2:
                        copy(prefix + " " + aireplay_dir + " --ignore-negative-one --deauth 0 -a 00:11:22:33:44:55 -c 01:23:45:67:89:0a " + iface, getView());
                        break;
                    case 3:
                        copy(prefix + " " + mdk3_dir + " " + iface + " b -m", getView());
                        break;
                }
                dismiss();
            }
        });
        return builder.create();
    }
}
