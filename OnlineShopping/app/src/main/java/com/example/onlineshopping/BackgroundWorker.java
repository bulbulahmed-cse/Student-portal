package com.example.onlineshopping;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;

    AlertDialog alertDialog;
    String type;
    static String result = "";
    String line = "";
    String flag = "";

    //for getting some value
    static String productJsonString = "";
    static String buyerId = "";
    static String sellerId = "";

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {
        type = voids[0];

        //String ipAddress = "192.168.31.162";

        String seller_login_url = "https://bulbul007.000webhostapp.com/onlineShope/seller_login.php";
        String buyer_login_url = "https://bulbul007.000webhostapp.com/onlineShope/buyer_login.php";
        String seller_register_url = "https://bulbul007.000webhostapp.com/onlineShope/seller_register.php";
        String seller_list_url = "https://bulbul007.000webhostapp.com/onlineShope/get_all_seller.php";
        String product_list_url = "https://bulbul007.000webhostapp.com/onlineShope/get_product.php";
        String buyer_order_list_url = "https://bulbul007.000webhostapp.com/onlineShope/buyer_order_list.php";
        String set_order_url = "https://bulbul007.000webhostapp.com/onlineShope/set_order.php";
        String add_product_url = "https://bulbul007.000webhostapp.com/onlineShope/add_product.php";
        String pending_order_url = "https://bulbul007.000webhostapp.com/onlineShope/pending_order.php";


        if (type.equals("seller_login")) {
            result = "";
            line = "";
            try {
                String user_email = voids[1];
                String user_pass = voids[2];
                URL url = new URL(seller_login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_email", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (type.equals("buyer_login")) {
            result = "";
            line = "";
            try {
                String user_email = voids[1];
                String user_pass = voids[2];
                URL url = new URL(buyer_login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_email", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("seller_register")) {
            result = "";
            line = "";
            try {
                String user_name = voids[1];
                String user_email = voids[2];
                String user_pass = voids[3];
                URL url = new URL(seller_register_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("user_email", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));


                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("seller_list")) {
            result = "";
            line = "";
            try {

                String JSON_STRING;

                URL url = new URL(seller_list_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("product_list")) {
            result = "";
            line = "";
            try {

                String category = voids[1];

                String JSON_STRING;

                URL url = new URL(product_list_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("category", "UTF-8") + "=" + URLEncoder.encode(category, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (type.equals("buyer_order_list")) {
            result = "";
            line = "";
            try {

                String buyer_id = voids[1];

                String JSON_STRING;

                URL url = new URL(buyer_order_list_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("buyer_id", "UTF-8") + "=" + URLEncoder.encode(buyer_id, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (type.equals("set_order")) {
            result = "";
            line = "";
            try {
                String product_id = voids[1];
                String product_name = voids[2];
                String product_price = voids[3];
                String product_quantity = voids[4];
                String buyer_id = voids[5];
                String seller_id = voids[6];

                URL url = new URL(set_order_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("product_id", "UTF-8") + "=" + URLEncoder.encode(product_id, "UTF-8") + "&" +
                        URLEncoder.encode("product_name", "UTF-8") + "=" + URLEncoder.encode(product_name, "UTF-8") + "&" +
                        URLEncoder.encode("product_price", "UTF-8") + "=" + URLEncoder.encode(product_price, "UTF-8") + "&" +
                        URLEncoder.encode("product_quantity", "UTF-8") + "=" + URLEncoder.encode(product_quantity, "UTF-8") + "&" +
                        URLEncoder.encode("buyer_id", "UTF-8") + "=" + URLEncoder.encode(buyer_id, "UTF-8") + "&" +
                        URLEncoder.encode("seller_id", "UTF-8") + "=" + URLEncoder.encode(seller_id, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));


                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("add_product")) {
            result = "";
            line = "";
            try {
                String product_name = voids[1];
                String product_category = voids[2];
                String product_price = voids[3];
                String product_details = voids[4];
                String seller_id = voids[5];

                flag = seller_id;

                URL url = new URL(add_product_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("product_name", "UTF-8") + "=" + URLEncoder.encode(product_name, "UTF-8") + "&" +
                        URLEncoder.encode("product_category", "UTF-8") + "=" + URLEncoder.encode(product_category, "UTF-8") + "&" +
                        URLEncoder.encode("product_price", "UTF-8") + "=" + URLEncoder.encode(product_price, "UTF-8") + "&" +
                        URLEncoder.encode("product_details", "UTF-8") + "=" + URLEncoder.encode(product_details, "UTF-8") + "&" +
                        URLEncoder.encode("seller_id", "UTF-8") + "=" + URLEncoder.encode(seller_id, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));


                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("pending_order_list")) {
            result = "";
            line = "";
            try {

                String seller_id = voids[1];

                flag = seller_id;

                String JSON_STRING;

                URL url = new URL(pending_order_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("seller_id", "UTF-8") + "=" + URLEncoder.encode(seller_id, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String result) {
        if (type.equals("buyer_login") && !result.equals("Wrong email or password")) {

            Toast.makeText(context, "Successfully login " + result, Toast.LENGTH_SHORT).show();
            buyerId = result;
            Intent in = new Intent(context, BuyerActivity.class);
            context.startActivity(in);


        }
        else if (type.equals("seller_login") && !result.equals("Wrong email or password")) {

            Toast.makeText(context, "Successfully login " + result, Toast.LENGTH_SHORT).show();
            sellerId = result;
            Intent in = new Intent(context, SellerActivity.class);
            context.startActivity(in);


        }else if (type.equals("product_list")) {
            /*Intent in = new Intent(context,BuyerActivity.class);
            in.putExtra("product_json", result);
            context.startActivity(in);*/

            productJsonString = result;
        }else if (type.equals("buyer_order_list")) {
            /*Intent in = new Intent(context,BuyerActivity.class);
            in.putExtra("product_json", result);
            context.startActivity(in);*/
            //Toast.makeText(context, "Buyer Order: " + result, Toast.LENGTH_SHORT).show();
            productJsonString = result;
        }else if (type.equals("seller_register")) {
            /*Intent in = new Intent(context,BuyerActivity.class);
            in.putExtra("product_json", result);
            context.startActivity(in);*/
            Toast.makeText(context, "Registration " + result, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(context,MainActivity.class);
            context.startActivity(intent);
         }
        else if (type.equals("set_order")) {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Order status");
            alertDialog.setMessage(result);
            alertDialog.show();
        }else if (type.equals("add_product")) {

            sellerId = flag;

            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Add Product status");
            alertDialog.setMessage(result);
            alertDialog.show();

            Intent in = new Intent(context, SellerActivity.class);
            context.startActivity(in);

        }else if (type.equals("pending_order_list")) {

            sellerId = flag;

            /*alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Pending Product status");
            alertDialog.setMessage(result);
            alertDialog.show();*/

            productJsonString = result;

        }else {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login status");
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
