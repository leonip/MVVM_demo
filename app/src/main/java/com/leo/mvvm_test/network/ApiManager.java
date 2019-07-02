package com.leo.mvvm_test.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leo.mvvm_test.MainActivity;
import com.leo.mvvm_test.dao.FreeAppsResponse;

public class ApiManager {

    private static final String TOPFREEAPP_API = "https://itunes.apple.com/hk/rss/topfreeapplications/limit=100/json";
    private RequestQueue requestQueue;
    private Gson gson_demo;

    public ApiManager(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson_demo = gsonBuilder.create();
    }

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(MainActivity.class.getSimpleName(), error.toString());
        }
    };


    public void getTopFreeApplication(SuccessResponse<FreeAppsResponse> successResponse) {
        StringRequest request = new StringRequest(Request.Method.GET, TOPFREEAPP_API,
                (response) -> {
            FreeAppsResponse entity = gson_demo.fromJson(response, FreeAppsResponse.class);
            successResponse.onSuccess(entity);
        },
                onPostsError);

        requestQueue.add(request);

    }

    public interface SuccessResponse<T>{
        void onSuccess(T obj);
    }

    public interface ErrorResponse{
        void onError();
    }

}
