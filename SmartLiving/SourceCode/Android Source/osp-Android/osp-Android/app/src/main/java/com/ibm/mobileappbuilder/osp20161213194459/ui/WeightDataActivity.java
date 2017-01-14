

package com.ibm.mobileappbuilder.osp20161213194459.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.osp20161213194459.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * WeightDataActivity list activity
 */
public class WeightDataActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        if(isTaskRoot()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        setTitle(getString(R.string.weightDataActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return WeightDataFragment.class;
    }

}
