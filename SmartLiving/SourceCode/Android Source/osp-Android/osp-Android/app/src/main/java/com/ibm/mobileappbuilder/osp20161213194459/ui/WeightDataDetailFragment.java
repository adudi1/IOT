
package com.ibm.mobileappbuilder.osp20161213194459.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.osp20161213194459.R;
import ibmmobileappbuilder.actions.ActivityIntentLauncher;
import ibmmobileappbuilder.actions.OpenUriAction;
import ibmmobileappbuilder.util.ColorUtils;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.osp20161213194459.ds.WeightdbDSSchemaItem;
import ibmmobileappbuilder.ds.CloudantDatasource;
import ibmmobileappbuilder.cloudant.factory.CloudantDatastoresFactory;
import java.net.URI;

public class WeightDataDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<WeightdbDSSchemaItem>  {

    private Datasource<WeightdbDSSchemaItem> datasource;
    public static WeightDataDetailFragment newInstance(Bundle args){
        WeightDataDetailFragment fr = new WeightDataDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public WeightDataDetailFragment(){
        super();
    }

    @Override
    public Datasource<WeightdbDSSchemaItem> getDatasource() {
        if (datasource != null) {
            return datasource;
    }
       datasource = CloudantDatasource.cloudantDatasource(
              CloudantDatastoresFactory.create("weightdata"),
              URI.create("https://7ab7eba0-15f4-4569-85c5-39a1568e1d7e-bluemix.cloudant.com/weightdata/"),
              WeightdbDSSchemaItem.class,
              new SearchOptions()
              );
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.weightdatadetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final WeightdbDSSchemaItem item, View view) {
        if (item.name != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.name);
            ColorUtils.tintIcon(view0.getCompoundDrawables()[2], R.color.textColor, getActivity());
            bindAction(view0, new OpenUriAction(new ActivityIntentLauncher(), "https:/" + item.name + "/LED=ON"));
        }
        if (item.weight != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(StringUtils.intToString(item.weight) + " grams");
            
        }
        if (item.date != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(item.date);
            
        }
    }

    @Override
    protected void onShow(WeightdbDSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle("Weight Data");
    }
}
