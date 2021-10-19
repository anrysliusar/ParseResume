import fileParsers.ParserDoc;
import fileParsers.ParserPDF;
import models.CandidateDto;
import service.CandidateParsingImpl;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        CandidateParsingImpl candidateParsing = new CandidateParsingImpl();
        CandidateDto candidateDto = candidateParsing.parseCandidate("CV_Andrii_Sliusarenko.pdf");
        System.out.println(candidateDto.toString());





    }
}
