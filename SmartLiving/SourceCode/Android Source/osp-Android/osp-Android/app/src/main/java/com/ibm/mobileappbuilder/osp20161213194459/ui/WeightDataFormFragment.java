
package com.ibm.mobileappbuilder.osp20161213194459.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.ibm.mobileappbuilder.osp20161213194459.presenters.WeightDataFormFormPresenter;
import com.ibm.mobileappbuilder.osp20161213194459.R;
import ibmmobileappbuilder.ds.CloudantDatasource;
import ibmmobileappbuilder.ui.FormFragment;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.views.TextWatcherAdapter;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.osp20161213194459.ds.WeightdbDSSchemaItem;
import ibmmobileappbuilder.ds.CloudantDatasource;
import ibmmobileappbuilder.cloudant.factory.CloudantDatastoresFactory;
import java.net.URI;
import static ibmmobileappbuilder.analytics.injector.PageViewBehaviorInjector.pageViewBehavior;

public class WeightDataFormFragment extends FormFragment<WeightdbDSSchemaItem> {

    private CrudDatasource<WeightdbDSSchemaItem> datasource;

    public static WeightDataFormFragment newInstance(Bundle args){
        WeightDataFormFragment fr = new WeightDataFormFragment();
        fr.setArguments(args);

        return fr;
    }

    public WeightDataFormFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        // the presenter for this view
        setPresenter(new WeightDataFormFormPresenter(
                (CrudDatasource) getDatasource(),
                this));

                addBehavior(pageViewBehavior("WeightDataForm"));
    }

    @Override
    protected WeightdbDSSchemaItem newItem() {
        return new WeightdbDSSchemaItem();
    }

    @Override
    protected int getLayout() {
        return R.layout.weightdataform_form;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final WeightdbDSSchemaItem item, View view) {
        
        bindString(R.id.name, item.name, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.name = s.toString();
            }
        });
        
        
        bindLong(R.id.weight, item.weight, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.weight = StringUtils.parseLong(s.toString());
            }
        });
        
        
        bindString(R.id.date, item.date, new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                item.date = s.toString();
            }
        });
        
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
}
