package com.example.rnishiha.dialogfragmentsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class SampleDialog extends AlertDialog {

    public static void show(Context context) {
        TranslucentActivity.show(context);
    }

    public static class TranslucentActivity extends FragmentActivity {
        public static void show(Context context) {
            Intent intent = new Intent(context, TranslucentActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            context.startActivity(intent);
        }

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            SampleDialog.showDialog(this);
        }
    }

    private static void showDialog(FragmentActivity activity) {
        if (activity == null) {
            return;
        }

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        if (fragmentManager == null) {
            return;
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (transaction == null) {
            return;
        }

        transaction.add(new MyDialogFragment(), null);
        transaction.commitAllowingStateLoss();
    }

    public static class MyDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            setRetainInstance(true);
            setCancelable(true);
            return new SampleDialog(getContext());

        }

        @Override
        public void onCancel(DialogInterface dialog) {
            super.onCancel(dialog);

            Activity ownerActivity = getActivity();
            if (ownerActivity != null) {
                ownerActivity.finish();
            }
        }
    }

    private SampleDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sample_dialog);
    }

    private void close() {
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity == null) {
            return;
        }

        ownerActivity.finish();
    }
}
