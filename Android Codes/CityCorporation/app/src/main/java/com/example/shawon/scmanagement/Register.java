package com.example.shawon.scmanagement;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment {

    EditText e1,e2,e3,e4;
    Button b1;
    String Name;
    String Email;
    String password,nid;

    DBHepler db;
    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_register, container, false);
        db=new DBHepler(getActivity());
        e1=(EditText)v.findViewById(R.id.Nameedit);
        e2=(EditText)v.findViewById(R.id.emailedit);
        e3=(EditText)v.findViewById(R.id.passedit);
        e4=(EditText)v.findViewById(R.id.Nedit);
        b1=(Button)v.findViewById(R.id.button3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Name=e1.getText().toString();
                Email =e2.getText().toString();
                password=e3.getText().toString();
                nid=e4.getText().toString();

                String url = "http://citymanagement.000webhostapp.com/register.php";

                url = url.replaceAll(" ", "%20");
          StringRequest s=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        e1.setText("");
                        e2.setText("");
                        e3.setText("");
                        e4.setText("");

                        Toast.makeText(getActivity(),"Respones:"+response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"Error:"+error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {





                        Map<String,String> params=new HashMap<String, String>();

                        params.put("name",Name);
                        params.put("email",Email);
                        params.put("password",password);
                        params.put("NID",nid);

                      //  Toast.makeText(getActivity(), "Registered", Toast.LENGTH_SHORT).show();
                    /*    Fragment someFragment = new LogIn();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.activity_main, someFragment ); // give your fragment container id in first parameter
                        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                        transaction.commit();*/

                        return params;
                    }
                };
                RequestQueue referenceQueue= Volley.newRequestQueue(getActivity());
               referenceQueue.add(s);
            }
        });




        // Inflate the layout for this fragment
        return v;
    }

}
