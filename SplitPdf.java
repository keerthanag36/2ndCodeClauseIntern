package demoPdfSplitter;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;

public class SplitPdf {
    public static void main(String[] args) {
        try {
            // Load the PDF file
            File inputFile = new File("C:\\Users\\Admin\\Desktop\\Java\\Keerthana_Resume(updated4);.pdf");
            PDDocument document = PDDocument.load(inputFile);

            // Create a PDF splitter instance
            Splitter splitter = new Splitter();

            // Split the PDF into individual pages
            List<PDDocument> pages = splitter.split(document);

            // Get the parent directory of the input file
            String parentDirectory = inputFile.getParent();

            // Iterate through each page and save it as a separate PDF file in the same directory
            Iterator<PDDocument> iterator = pages.iterator();
            int pageNumber = 1;
            while (iterator.hasNext()) {
                PDDocument page = iterator.next();
                String outputFileName = "output-" + pageNumber + ".pdf";
                String outputPath = parentDirectory + File.separator + outputFileName;
                page.save(outputPath);
                pageNumber++;
                page.close();
            }

            // Close the input PDF document
            document.close();

            System.out.println("PDF split successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
