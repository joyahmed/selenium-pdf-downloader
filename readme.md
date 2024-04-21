# Selenium PDF Downloader

## Overview

This project automates the download of a PDF file from a webpage using Selenium WebDriver in Java. The specific task is to download a printable PDF of the "Selenium Cheat Sheet" from a given URL.

## Components

### 1. Main Class (Main.java)

This class initializes the Selenium WebDriver, navigates to the webpage containing the link to download the PDF, and invokes the `PdfDownloader` class to handle the download process.

### 2. PdfDownloader Class (PdfDownloader.java)

The `PdfDownloader` class contains the logic for downloading the PDF file. It utilizes Selenium WebDriver to find the download link, extract the URL, and then utilize the `FileUtils` class to download the PDF file from the URL.

### 3. FileUtils Class (FileUtils.java)

The `FileUtils` class provides utility methods for file-related operations. It uses Java's built-in `HttpClient` to perform the actual download of the PDF file from the URL.

## Approach

1. **Selenium WebDriver**: Selenium WebDriver is used to automate the web browser interaction. It allows us to navigate to the webpage, locate the download link, and extract the URL of the PDF file.

2. **HttpClient**: Java's `HttpClient` library is used to perform the file download. This approach ensures that the PDF file is downloaded directly from the URL without relying on the browser's default behavior.

3. **Separation of Concerns**: The project follows the principle of separation of concerns by dividing the functionality into separate classes (`Main`, `PdfDownloader`, `FileUtils`), each responsible for a specific aspect of the process.

## Rationale for Approach

The project adopts this approach due to the following reasons:

- **Browser Behavior Changes**: Many modern browsers now open PDF files in their built-in PDF viewers instead of directly downloading them. This behavior makes it challenging to automate the download process solely through the browser.

- **Default Profile Limitations**: Selenium WebDriver typically does not interact with the browser's default profile, making it difficult to disable the browser's PDF viewer or change its settings.

- **Direct Download**: Using Java's `HttpClient` allows for a direct download of the PDF file from the URL, bypassing any browser-related limitations or behaviors.
