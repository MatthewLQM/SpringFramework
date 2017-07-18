package com.matthew.service;

import com.matthew.common.argument.AutoGeneratorArguments;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AutoGeneratorService {
    public List<String> autoGenerate(AutoGeneratorArguments args){
        ArrayList<String> before = findReplaced(args.getOriginString());
        ArrayList<String> result = findAndReplace(args, before);
        return result;
    }

    private static ArrayList<String> findReplaced(String origin){
        ArrayList<String> before = new ArrayList<>();
        Pattern pattern = Pattern.compile("@@[a-z1-9A-Z]*@@");
        Matcher matcher = pattern.matcher(origin);
        while(matcher.find()){
            String temp = matcher.group(0);
            before.add(temp.substring(2, temp.length() - 2));
        }
        return before;
    }

    private static String findAndReplaceOneSentence(String origin, ArrayList<String> replaceList, ArrayList<String> targetList){
        String result = new String(origin);
        for(int i = 0; i < targetList.size(); i++){
            result = result.replaceFirst("@@" + replaceList.get(i) + "@@", targetList.get(i));
        }
        return result;
    }

    private static ArrayList<String> findAndReplace(AutoGeneratorArguments argumentForReplace, ArrayList<String> before){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < argumentForReplace.getEnd().get(0) - argumentForReplace.getBegin().get(0); i++){
            ArrayList<String> targetList = new ArrayList<>();
            for(int j = 0; j < argumentForReplace.getBegin().size(); j++){
                targetList.add(String.valueOf(argumentForReplace.getBegin().get(j) + i));
            }
            String temp = findAndReplaceOneSentence(argumentForReplace.getOriginString(), before, targetList);
            result.add(temp);
        }
        return result;
    }
}
