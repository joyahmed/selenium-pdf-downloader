import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FileUtils {
    public static void downloadFile(String fileUrl, String fileName) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        try {
            HttpResponse<InputStream> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

            // Create a file output stream
            FileOutputStream outputStream = new FileOutputStream(fileName);

            // Copy the input stream to the file output stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = httpResponse.body().read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close the streams
            outputStream.close();
            httpResponse.body().close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
