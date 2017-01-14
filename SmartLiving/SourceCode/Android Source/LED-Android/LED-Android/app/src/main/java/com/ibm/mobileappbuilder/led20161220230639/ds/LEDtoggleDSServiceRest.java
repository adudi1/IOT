
package com.ibm.mobileappbuilder.led20161220230639.ds;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.PUT;

public interface LEDtoggleDSServiceRest{

	@GET("/app/5859ba9cc23fb60400abd508/r/lEDtoggleDS")
	void queryLEDtoggleDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<LEDtoggleDSItem>> cb);

	@GET("/app/5859ba9cc23fb60400abd508/r/lEDtoggleDS/{id}")
	void getLEDtoggleDSItemById(@Path("id") String id, Callback<LEDtoggleDSItem> cb);

	@DELETE("/app/5859ba9cc23fb60400abd508/r/lEDtoggleDS/{id}")
  void deleteLEDtoggleDSItemById(@Path("id") String id, Callback<LEDtoggleDSItem> cb);

  @POST("/app/5859ba9cc23fb60400abd508/r/lEDtoggleDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<LEDtoggleDSItem>> cb);

  @POST("/app/5859ba9cc23fb60400abd508/r/lEDtoggleDS")
  void createLEDtoggleDSItem(@Body LEDtoggleDSItem item, Callback<LEDtoggleDSItem> cb);

  @PUT("/app/5859ba9cc23fb60400abd508/r/lEDtoggleDS/{id}")
  void updateLEDtoggleDSItem(@Path("id") String id, @Body LEDtoggleDSItem item, Callback<LEDtoggleDSItem> cb);

  @GET("/app/5859ba9cc23fb60400abd508/r/lEDtoggleDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
}
