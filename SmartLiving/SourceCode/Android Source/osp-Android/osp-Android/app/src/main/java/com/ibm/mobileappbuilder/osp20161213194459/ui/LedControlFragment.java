
package com.ibm.mobileappbuilder.osp20161213194459.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.osp20161213194459.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.ImageView;
import android.widget.TextView;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.osp20161213194459.ds.Item;
import com.ibm.mobileappbuilder.osp20161213194459.ds.EmptyDatasource;
import static ibmmobileappbuilder.analytics.injector.PageViewBehaviorInjector.pageViewBehavior;

public class LedControlFragment extends ibmmobileappbuilder.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    private SearchOptions searchOptions;

    public static LedControlFragment newInstance(Bundle args){
        LedControlFragment card = new LedControlFragment();
        card.setArguments(args);

        return card;
    }

    public LedControlFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addBehavior(pageViewBehavior("LedControl"));
        searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = EmptyDatasource.getInstance(searchOptions);
        return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.ledcontrol_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
        
        ImageView view1 = (ImageView) view.findViewById(R.id.view1);
        ImageLoader view1Loader = new PicassoImageLoader(view.getContext());
        view1Loader.load(imageLoaderRequest()
                        .withResourceToLoad(R.drawable.png_defaultmenuicon)
                        .withTargetView(view1)
                        .build()
        );
        
        
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle("LedControl");
    }
}
