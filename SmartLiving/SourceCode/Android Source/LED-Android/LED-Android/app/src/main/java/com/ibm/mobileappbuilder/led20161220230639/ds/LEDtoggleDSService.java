
package com.ibm.mobileappbuilder.led20161220230639.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.led20161220230639.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "LEDtoggleDSService" REST Service implementation
 */
public class LEDtoggleDSService extends RestService<LEDtoggleDSServiceRest>{

    public static LEDtoggleDSService getInstance(){
          return new LEDtoggleDSService();
    }

    private LEDtoggleDSService() {
        super(LEDtoggleDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "0TF6ly8k";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/5859ba9cc23fb60400abd508",
                path,
                "apikey=0TF6ly8k");
    }

}
