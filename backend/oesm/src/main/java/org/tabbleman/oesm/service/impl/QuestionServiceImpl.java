package org.tabbleman.oesm.service.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.repository.QuestionRepository;
import org.tabbleman.oesm.service.QuestionService;

import java.awt.image.BandCombineOp;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    
    @Override
    public List<Question> getAllQuestions() {
        return null;
    }

    @Override
    public List<Question> getAllSingleQuestions() {
        return null;
    }

    @Override
    public List<Question> getAllMultipleQuestions() {
        return null;
    }

    @Override
    public List<Question> getAllTfQuestions() {
        return null;
    }

    @Override
    public String uploadQuestion(MultipartFile questionCsv) {
        try{
            InputStream is = questionCsv.getInputStream ();
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            List<Question> questions = new ArrayList<>();
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(buf);

            for(CSVRecord record : csvParser){
                String questionType = record.get("questionType");
                String questionName = record.get("questionName");
                String questionAnswer = record.get("questionAnswer");
                String questionChoices = record.get("questionChoices");
                Question question = new Question(questionType, questionName, questionAnswer, questionChoices);
//                System.out.println(question.toString());
                questionRepository.save(question);
            }
            return "OK";
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Error!";
    }

}
