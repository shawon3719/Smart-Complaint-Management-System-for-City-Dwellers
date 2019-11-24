package com.example.shawon.scmanagement;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



public class MySingleton {
    private static MySingleton mysq;
    private RequestQueue requestQueue;
    private static Context mcontex;


    private MySingleton(Context contex) {

        mcontex = contex;
        requestQueue = getRequestQueue();


    }
public static synchronized MySingleton getIntance(Context context){


    if(mysq==null){

        mysq=new MySingleton(context);


    }
return mysq;

}
public  RequestQueue getRequestQueue(){
    if(requestQueue==null){


        requestQueue= Volley.newRequestQueue(mcontex.getApplicationContext());
    }
    return requestQueue;
}
public <T> void addtoRequest(Request<T> request){

requestQueue.add(request);
}


}
