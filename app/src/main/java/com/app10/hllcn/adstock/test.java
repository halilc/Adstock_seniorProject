package com.app10.hllcn.adstock;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.LocationRequest;
import com.onesignal.OneSignal;
import java.util.HashMap;
import java.util.Map;

public class test extends Activity {

    private LocationRequest mLocationRequest;
    private long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 10000; /* 2 sec */
    private RequestQueue queue;
    private String url;
    private int counter = 1;

    private String msg;
    private Button facebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        queue = Volley.newRequestQueue(this);  // this = context
        url = "http://178.62.210.159:8000/api/send_location";
        OneSignal.startInit(getApplicationContext())
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        for(int i=0;i< 100 ; i++){
            httppost((i+1)*0.5,(i+1)*0.5);
            Log.d("testPost", String.valueOf(i));
        }

    }
    public void httppost( final Double latitude ,final Double longitude){
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);


                        Log.d("", String.valueOf(counter));
                        counter++;

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        //Log.d("Error.Response", response);
                        VolleyLog.d("ErrorVolley", "Error: " + error.getStackTrace());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_id","2" );
                params.put("lat", latitude.toString());
                params.put("long", longitude.toString());
                return params;
            }
        };
        queue.add(postRequest);
    }

}