
package com.ibm.mobileappbuilder.led20161220230639.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.led20161220230639.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.TextView;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.led20161220230639.ds.LEDtoggleDSItem;
import com.ibm.mobileappbuilder.led20161220230639.ds.LEDtoggleDS;

public class MainFragment extends ibmmobileappbuilder.ui.DetailFragment<LEDtoggleDSItem>  {

    private Datasource<LEDtoggleDSItem> datasource;
    private SearchOptions searchOptions;

    public static MainFragment newInstance(Bundle args){
        MainFragment card = new MainFragment();
        card.setArguments(args);

        return card;
    }

    public MainFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = LEDtoggleDS.getInstance(searchOptions);
        return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.main_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final LEDtoggleDSItem item, View view) {
        if (item.togglevalue != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(StringUtils.booleanToString(item.togglevalue));
            
        }
    }

    @Override
    protected void onShow(LEDtoggleDSItem item) {
        // set the title for this fragment
        getActivity().setTitle("main");
    }
}
