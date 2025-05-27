import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
public class RestApiClient{
    public static void main(String[] args){
        try{
            String endpoint = "https://jsonplaceholder.typicode.com/users";
            URL resourceUrl = new URL(endpoint);
            HttpURLConnection connection=(HttpURLConnection)resourceUrl.openConnection();
            connection.setRequestMethod("GET");
            int statusCode=connection.getResponseCode();
            if(statusCode==HttpURLConnection.HTTP_OK){
                BufferedReader reader= new BufferedReader(connection.getInputStream());
                String line;
                StringBuilder jsonData= new StringBuilder();
                while((line=reader.readLine())!=null){
                    jsonData.append(line);
                }
                reader.close();
                JSONArray userArray= new JSONArray(jsonData.toString());
                for(int i=0;i<userArray.length();i++){
                    JSONObject userObj=userArray.getJSONObject(i);
                    System.out.println("Name:"+userObj.getString("name"));
                    System.out.println("Email:"+userObj.getString("email"));
                    System.out.println("City:"+userObj.getJSONObject("adderess").getString("city"));
                    System.out.println("-----------");
                }
            }
            else{
                System.out.println("GETrequest failed. Response Code:"+StatusCode);
            }

            
                }
                catch(Exception exception){
                    exception.printStackTrace();
                }
            }
        }
    
