package com.example.shawon.scmanagement;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogIn extends Fragment {
    TextView t1,t2,t3;
    EditText e1,e2;
    Button b1;
    String username,password;
    int num=0,snum=0;DBHepler dbHepler;
    Fragment someFragment;

    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "City" ;
    public static final String Text = "email" ;
    public LogIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_log_in, container, false);
        dbHepler=new DBHepler(getActivity());
        t1=(TextView)v.findViewById(R.id.qw);
        t2=(TextView)v.findViewById(R.id.tx3);
        t3=(TextView)v.findViewById(R.id.tx4);
        e1=(EditText)v.findViewById(R.id.edit);
        e2=(EditText)v.findViewById(R.id.edit2);
        b1=(Button)v.findViewById(R.id.button3);

        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username=e1.getText().toString();
                password=e2.getText().toString();







                if(e1.getText().length()!=0&&e2.getText().length()!=0){
                    userLogin(username,password);
                }

                else{
                    t2.setText("Please insert correct information!");
                }

            }
        });



        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment someFragment = new Register();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.activity_main, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
    private void userLogin(final String email, final String password){
        String url = "http://citymanagement.000webhostapp.com/login.php";

        url = url.replaceAll(" ", "%20");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.trim().equals("success")){
                    String eo  = e1.getText().toString();
                    String eo1  = e2.getText().toString();
                    e1.setText("");
                   e2.setText("");



                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString("Mail", eo);

                    editor.commit();
                    someFragment = new Page();
                   /* Bundle bundle=new Bundle();
                    bundle.putString("Email", eo);
                    bundle.putString("Pass", eo1);
                    //set Fragmentclass Arguments

                    someFragment.setArguments(bundle);*/

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.activity_main, someFragment ); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                }else{
                    Toast.makeText(getActivity(), "Failed "+response, Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("email", email);
                map.put("password", password);

                return map;
            }
        };
        RequestQueue referenceQueue= Volley.newRequestQueue(getActivity());
        referenceQueue.add(stringRequest);
    }

}
