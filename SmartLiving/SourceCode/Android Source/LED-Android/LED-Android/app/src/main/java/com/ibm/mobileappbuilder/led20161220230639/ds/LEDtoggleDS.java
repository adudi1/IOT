

package com.ibm.mobileappbuilder.led20161220230639.ds;

import android.content.Context;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.TypedByteArrayUtils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * "LEDtoggleDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class LEDtoggleDS extends AppNowDatasource<LEDtoggleDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private LEDtoggleDSService service;

    public static LEDtoggleDS getInstance(SearchOptions searchOptions){
        return new LEDtoggleDS(searchOptions);
    }

    private LEDtoggleDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = LEDtoggleDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<LEDtoggleDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<LEDtoggleDSItem>>() {
                @Override
                public void onSuccess(List<LEDtoggleDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new LEDtoggleDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getLEDtoggleDSItemById(id, new Callback<LEDtoggleDSItem>() {
                @Override
                public void success(LEDtoggleDSItem result, Response response) {
                                        listener.onSuccess(result);
                }

                @Override
                public void failure(RetrofitError error) {
                                        listener.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getItems(final Listener<List<LEDtoggleDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<LEDtoggleDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryLEDtoggleDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<LEDtoggleDSItem>>() {
            @Override
            public void success(List<LEDtoggleDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{null};
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
                service.getServiceProxy().distinct(searchStr, conditions, new Callback<List<String>>() {
             @Override
             public void success(List<String> result, Response response) {
                                  result.removeAll(Collections.<String>singleton(null));
                 listener.onSuccess(result);
             }

             @Override
             public void failure(RetrofitError error) {
                                  listener.onFailure(error);
             }
        });
    }

    @Override
    public URL getImageUrl(String path) {
        return service.getImageUrl(path);
    }

    @Override
    public void create(LEDtoggleDSItem item, Listener<LEDtoggleDSItem> listener) {
                          service.getServiceProxy().createLEDtoggleDSItem(item, callbackFor(listener));
          }

    private Callback<LEDtoggleDSItem> callbackFor(final Listener<LEDtoggleDSItem> listener) {
      return new Callback<LEDtoggleDSItem>() {
          @Override
          public void success(LEDtoggleDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(LEDtoggleDSItem item, Listener<LEDtoggleDSItem> listener) {
                          service.getServiceProxy().updateLEDtoggleDSItem(item.getIdentifiableId(), item, callbackFor(listener));
          }

    @Override
    public void deleteItem(LEDtoggleDSItem item, final Listener<LEDtoggleDSItem> listener) {
                service.getServiceProxy().deleteLEDtoggleDSItemById(item.getIdentifiableId(), new Callback<LEDtoggleDSItem>() {
            @Override
            public void success(LEDtoggleDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<LEDtoggleDSItem> items, final Listener<LEDtoggleDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<LEDtoggleDSItem>>() {
            @Override
            public void success(List<LEDtoggleDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<LEDtoggleDSItem> items){
        List<String> ids = new ArrayList<>();
        for(LEDtoggleDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}
