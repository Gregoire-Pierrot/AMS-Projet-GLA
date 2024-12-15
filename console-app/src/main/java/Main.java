import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        DBInitializer db = DBInitializer.getInstance();

        JSONObject response = APIRequest.getInstance().sendGetRequest("/assets");
        
        if (response != null) {
            System.out.println(response.toString());
        }
    }
}