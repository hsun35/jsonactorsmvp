package com.example.hefen.jsonactorsmvp;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.hefen.jsonactorsmvp.app.AppController;
import com.example.hefen.jsonactorsmvp.model.Actor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hefen on 5/4/2018.
 */

public class Model implements IModel{
    IPresenter iPresenter;
    String tag_json_obj = "json_obj_req";
    String url = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
    List<Actor> actorList = new ArrayList<>();
    Model (IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public void sendCall() {
        JsonObjectRequest jsonObjReq =
                new JsonObjectRequest(Request.Method.GET,
                        url, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    Log.i("mylog", "get response");
                                    //StringBuilder sb = new StringBuilder();
                                    JSONArray jsonArray = response.getJSONArray("actors");
                                    actorList = new ArrayList<>();
                                    for(int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject actor = jsonArray.getJSONObject(i);
                                        String name = actor.getString("name");
                                        String country = actor.getString("country");
                                        String height = actor.getString("height");
                                        String image = actor.getString("image");
                                        Log.i("mylog", "name: " + name);


                                        Actor mActor = new Actor(name, country, height, image);
                                        actorList.add(mActor);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.i("mylog", "error " + e.getMessage());
                                }
                                if (actorList != null && actorList.size() != 0) {
                                    iPresenter.setData(actorList);
                                }

                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                        Log.i("mylog", "Error: " + error.getMessage());
                        // hide the progress dialog
                        //pDialog.hide();
                    }
                });
        if (AppController.getInstance() == null) {
            Log.i("mylog", "Error: null instance");
        } else {
            Log.i("mylog", "instance");
        }
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }
}
