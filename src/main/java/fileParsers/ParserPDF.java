package fileParsers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ParserPDF implements FileParser{
    private String content;
    private final File file;

    public ParserPDF(File file) {
        this.file = file;
    }

    @Override
    public String parse() {
        try {
            PDDocument document = PDDocument.load(file);
            var pdfStripper = new PDFTextStripper();
            content = pdfStripper.getText(document);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
