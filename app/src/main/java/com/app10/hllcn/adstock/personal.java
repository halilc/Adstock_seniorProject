package com.app10.hllcn.adstock;
import android.app.Activity;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class personal extends Activity {
    private RequestQueue queue;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peronal);
        queue = Volley.newRequestQueue(this);  // this = context
        url = "http://178.62.210.159:8000/api/send_location";
    }
    public void httppost( final Double latitude ,final Double longitude){
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
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
    public void androidCheckBoxClicked(View view) {
        // action for checkbox click
        switch (view.getId()) {
            case R.id.checkBox:
                //DO something when user check the box
                break;
            case R.id.checkBox2:
                //DO something when user check the box
                break;
            case R.id.checkBox3:
                //DO something when user check the box
                break;
            case R.id.checkBox4:
                //DO something when user check the box
                break;
            case R.id.checkBox5:
                //DO something when user check the box
                break;
            case R.id.checkBox6:
                //DO something when user check the box
                break;

        }

}
}