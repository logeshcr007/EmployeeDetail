package com.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.google.android.material.snackbar.Snackbar;

import java.net.URL;
import java.util.List;
import java.util.Random;


public class MyUtils {



    public static int getDynamicGradient() {
        int[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.CYAN, Color.GREEN};
        Random ranndom = new Random();
        int ranndomColor = ranndom.nextInt(5);
        return colors[ranndomColor];

    }

    public static Drawable getDrawable(int bgColor) {
        float[] arr = new float[]{0f, 0f, 0f, 30f};
        final GradientDrawable bg = new GradientDrawable();
        bg.setCornerRadii(arr);
        bg.setColor(bgColor);
        return bg;
    }

    public static GradientDrawable getGradientDrawable(int color, float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,
                new int[]{color, color});
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setCornerRadius(radius);
        return gradientDrawable;
    }

    public static void showMySnack(View view, String err) {
        Snackbar.make(view, err, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public static void showInternetSnack(View view){
        Snackbar.make(view, "Please Check Your Internet Connect.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public static void setCustomBackground(CardView view, String url, Context context) {
        try {
            URL myUrl = new URL(url);
            Bitmap bitmap = BitmapFactory.decodeStream(myUrl.openConnection().getInputStream());
            Drawable image = new BitmapDrawable(context.getResources(), bitmap);
        } catch (Exception e) {

        }
    }




    public static ProgressDialog getMyDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setMessage("Please wait...");
        return dialog;
    }


    public static String getTopicRequest(int topic){
        return "["+topic+"]";
    }
    public static String getSubTopicRequest(List<Integer> list){
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("[");
        if (list!=null && list.size() > 0)
        for (Integer s: list) {
            if (s!=null) {
                stringBuffer.append(s);
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

   public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

   /* public static boolean isValidEmailAddress(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
*/
    public static boolean isValidPhoneNumber(String phone){
        String regex = "(0/91)?[7-9][0-9]{9}";
        try {
            return phone.matches(regex);
        }catch (Exception e){
            return false;
        }
    }



}
