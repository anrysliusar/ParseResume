package service;

import fileParsers.FileParser;
import fileParsers.ParserDoc;
import fileParsers.ParserPDF;
import models.CandidateDto;
import models.SkillDto;

import java.io.File;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CandidateParsingImpl implements CandidateParsingService {
    private FileParser fileParser;
    private String content;


    @Override
    public CandidateDto parseCandidate(String filePath) {
        String contentFromFile = getContentFromFile(filePath);
        System.out.println(contentFromFile);
        String name = parseName();
        String email = parseEmail();
        String phone = parsePhone();
        String degree = parseDegree();
        String summary = parseSummary();
        Set<SkillDto> skills = parseSkills();
        return new CandidateDto(name, email, phone, degree, summary, filePath, skills);
    }

    private String getContentFromFile(String filePath){
        File file = new File(filePath);
        if(filePath.endsWith(".pdf")){
            fileParser = new ParserPDF(file);
        } else if(filePath.endsWith(".docx")){
            fileParser = new ParserDoc(file);
        } else {
            System.out.println("incorrect format");
            //todo incorrect format
        }
        return content = fileParser.parse();
    }


    private String parseName(){
        return null;
    }
    private String parseEmail(){
        return findByRegex(ResumeRegexp.EMAIL.toString());
    }
    public String parsePhone(){
        return findByRegex(ResumeRegexp.PHONE.toString());
    }
    private String parseDegree(){
        return null;
    }
    private String parseSummary(){
        return null;
    }

    private Set<SkillDto> parseSkills(){
        return null;
    }

    private String findByRegex(String regex){
        Pattern ptrn = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = ptrn.matcher(content);
        if(matcher.find()){
            return matcher.group();
        }
        return null;
    }
}
