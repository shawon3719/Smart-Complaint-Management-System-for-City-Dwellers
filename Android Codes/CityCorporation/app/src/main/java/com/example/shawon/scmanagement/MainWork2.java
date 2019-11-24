package com.example.shawon.scmanagement;


import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;
import static android.net.Uri.fromFile;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainWork2 extends Fragment {
    ImageView im;
    EditText Title, Description;
    TextView Location;
    String mapTypeString;
    public static final String MyPREFERENCES = "City" ;
    Button CamButton, upButton,locationbutton;
    private Camera mCamera;
    Bitmap bitmap;
    static final int cam_request = 1;
    static final int place_request = 2;
    private ProgressDialog pDialog;

    public MainWork2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {







View v=inflater.inflate(R.layout.fragment_main_work2, container, false);















        im = (ImageView)v. findViewById(R.id.camera_preview);

        Title = (EditText)v. findViewById(R.id.Title);
        Description = (EditText)v. findViewById(R.id.Description);
        Location = (TextView)v. findViewById(R.id.Location);

        CamButton = (Button)v. findViewById(R.id.button_capture);
        locationbutton = (Button)v. findViewById(R.id.locationButton);
        upButton = (Button)v. findViewById(R.id.uploadButton);

        SharedPreferences preferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mapTypeString = preferences.getString("Mail", "DEFAULT");





        CamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                cam.putExtra(MediaStore.EXTRA_OUTPUT, fromFile(file));
                startActivityForResult(cam, cam_request);
            }
        });

        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder p = new PlacePicker.IntentBuilder();
                Intent intent;
                try {
                    intent = p.build(getActivity());
                    startActivityForResult(intent, place_request);
                } catch (Exception ex) {
                    Toast.makeText(getActivity(),ex.toString(),Toast.LENGTH_LONG).show();

                }
            }
        });
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                pDialog = new ProgressDialog(getActivity());
                pDialog.setMessage("Uploading data...");
                pDialog.setCancelable(false);
                pDialog.show();


                File file = getFile();

                                StringRequest s = new StringRequest(Request.Method.POST, "http://citymanagement.000webhostapp.com/imageScript.php", new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        pDialog.dismiss();
                                        Toast.makeText(getActivity(), "Respones:" + response, Toast.LENGTH_LONG).show();
                                        Fragment someFragment = new Page();
                                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                        transaction.replace(R.id.activity_main, someFragment ); // give your fragment container id in first parameter
                                        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                                        transaction.commit();

                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getActivity(), "Error:" + error.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }) {
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {


                                        bitmap = ((BitmapDrawable) im.getDrawable()).getBitmap();

                                        String TitleText= Title.getText().toString();
                                        String DescriptionText= Description.getText().toString();
                                        String LocationText= Location.getText().toString();

                                        String imageString = ImageToString(bitmap);


                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("Email", mapTypeString);
                                        params.put("Title", TitleText);
                                        params.put("Description", DescriptionText);
                                        params.put("Location", LocationText);
                                        params.put("Image", imageString);
                                        return params;
                                    }
                                };

                                MySingleton.getIntance(getActivity()).addtoRequest(s);



                //  startActivityForResult(cam,cam_request);
            }
        });


        // Inflate the layout for this fragment
        return v;
    }
    private File getFile() {
        File file = new File("sdcard/city");
        if (!file.exists()) {
            file.mkdir();
        }
        File Imagefile = new File(file, "city.jpg");


        return Imagefile;
    }

    public String ImageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageByte = byteArrayOutputStream.toByteArray();
        String encode = Base64.encodeToString(imageByte, Base64.DEFAULT);


        return encode;

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == place_request) {
            if (resultCode == RESULT_OK) {


                Place place = PlacePicker.getPlace(data, getActivity());
                String toastMsg = place.getAddress().toString();
                Location.setText(toastMsg);
                // Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }

        }
        else  if (requestCode == cam_request) {
            if (resultCode == RESULT_OK) {
                String path = "sdcard/city/city.jpg";
                im.setImageDrawable(Drawable.createFromPath(path));}}
    }


}
