import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        sendGet();
        String imageUrl = "https://go.imgsmail.ru/static/web/img/common/search_embed.png";
        String destinationFile = "image.png";
        saveImage(imageUrl, destinationFile);
        //sendPost();
    }

    private static void sendGet() throws IOException {
        String str=null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите запрос");
            str = scanner.nextLine();
            if (str.equals("exit")) break;
            URL destination = new URL("https://go.mail.ru/search?q="+str);
            HttpURLConnection connection = (HttpURLConnection) destination.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("URL", "https://go.mail.ru/search?q="+str+str);
            int respCode = connection.getResponseCode();
            if (respCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String messageLine = null;
                while ((messageLine = reader.readLine()) != null) {
                    System.out.println(messageLine);
                }
                reader.close();
            }
        }

    }


        public static void saveImage(String imageUrl, String destinationFile) throws IOException {
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        }


    private static void sendPost() throws IOException {
//        URL destination = new URL("https://selfsolve.apple.com/wcResults.do");
//        HttpURLConnection connection = (HttpURLConnection) destination.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("User-Agent", "Mozzilla/5.0");
//        connection.setRequestProperty("Accept-Language", "en-US");
//
//        connection.setDoOutput(true);
//
//        String activaationParam = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
//        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
//        outputStream.writeBytes(activaationParam);
//        outputStream.flush();
//        outputStream.close();
//
//        int respCode = connection.getResponseCode();
//        if (respCode==200) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String messageLine = null;
//            while ((messageLine = reader.readLine()) != null) {
//                System.out.println(messageLine);
//            }
//            reader.close();
//        }
    }


}
