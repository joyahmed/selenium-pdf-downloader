import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PdfDownloader {
    public void downloadPdf() {
        // Set Chrome driver path
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");

        // Set download directory to desktop
        String downloadPath = System.getProperty("user.home") + "\\Desktop";

        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();

        // Configure Chrome preferences
        options.addArguments("download.default_directory=" + downloadPath);

        // Initialize WebDriver with Chrome options
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://intellipaat.com/blog/tutorial/selenium-tutorial/selenium-cheat-sheet/");

        // Find the link element
        WebElement link = driver.findElement(By.linkText("Download the printable PDF of Selenium cheat sheet"));

        // Get the URL of the PDF file
        String pdfUrl = link.getAttribute("href");

        // Extract filename from URL
        String fileName = pdfUrl.substring(pdfUrl.lastIndexOf("/") + 1);

        // Download the PDF file
        FileUtils.downloadFile(pdfUrl, downloadPath + "\\" + fileName);

        // Close the browser
        //driver.quit();
    }
}
