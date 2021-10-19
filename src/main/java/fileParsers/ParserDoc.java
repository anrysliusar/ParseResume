package fileParsers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

public class ParserDoc implements FileParser{
    private String content;
    private File file;

    public ParserDoc(File file) {
        this.file = file;
    }

    @Override
    public String parse() {
        try {
            var fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            content = extractor.getText();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return content;
    }
}
