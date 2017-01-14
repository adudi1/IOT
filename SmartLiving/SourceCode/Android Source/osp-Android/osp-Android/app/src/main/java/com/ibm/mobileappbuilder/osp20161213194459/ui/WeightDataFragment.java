package com.ibm.mobileappbuilder.osp20161213194459.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.osp20161213194459.R;
import ibmmobileappbuilder.behaviors.FabBehaviour;
import ibmmobileappbuilder.behaviors.SelectionBehavior;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.Constants;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.util.ViewHolder;
import java.util.List;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.osp20161213194459.ds.WeightdbDSSchemaItem;
import ibmmobileappbuilder.ds.CloudantDatasource;
import ibmmobileappbuilder.cloudant.factory.CloudantDatastoresFactory;
import java.net.URI;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;
import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;
import static ibmmobileappbuilder.analytics.injector.PageViewBehaviorInjector.pageViewBehavior;

/**
 * "WeightDataFragment" listing
 */
public class WeightDataFragment extends ListGridFragment<WeightdbDSSchemaItem>  {

    private Datasource<WeightdbDSSchemaItem> datasource;


    public static WeightDataFragment newInstance(Bundle args) {
        WeightDataFragment fr = new WeightDataFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addBehavior(pageViewBehavior("WeightData"));
        // Multiple selection
        SelectionBehavior<WeightdbDSSchemaItem> selectionBehavior = new SelectionBehavior<>(
            this,
            R.string.remove_items,
            R.drawable.ic_delete_alpha);

        selectionBehavior.setCallback(new SelectionBehavior.Callback<WeightdbDSSchemaItem>() {
            @Override
            public void onSelected(List<WeightdbDSSchemaItem> selectedItems) {
                getPresenter().deleteItems(selectedItems);
            }
        });
        addBehavior(selectionBehavior);

        
    }

    protected SearchOptions getSearchOptions() {
        SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
        return searchOptionsBuilder.build();
    }


    /**
    * Layout for the list itselft
    */
    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    /**
    * Layout for each element in the list
    */
    @Override
    protected int getItemLayout() {
        return R.layout.weightdata_item;
    }

    @Override
    protected Datasource<WeightdbDSSchemaItem> getDatasource() {
        if (datasource != null) {
            return datasource;
        }
       datasource = CloudantDatasource.cloudantDatasource(
              CloudantDatastoresFactory.create("weightdata"),
              URI.create("https://7ab7eba0-15f4-4569-85c5-39a1568e1d7e-bluemix.cloudant.com/weightdata/"),
              WeightdbDSSchemaItem.class,
              getSearchOptions()
              );
        return datasource;
    }

    @Override
    protected void bindView(WeightdbDSSchemaItem item, View view, int position) {
        
        ImageLoader imageLoader = new PicassoImageLoader(view.getContext());
        ImageView image = ViewHolder.get(view, R.id.image);
        imageLoader.load(imageLoaderRequest()
                        .withResourceToLoad(R.drawable.png_defaultmenuicon)
                        .withTargetView(image)
                        .fit()
                        .build()
        );
        
        
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.weight != null){
            title.setText(StringUtils.intToString(item.weight) + " grams");
            
        }
    }


    @Override
    public void showDetail(WeightdbDSSchemaItem item, int position) {
        // If we have forms, then we have to refresh when an item has been edited
        // Also with this we support list without details
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), WeightDataDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}
