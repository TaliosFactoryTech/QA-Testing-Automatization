package com.ea.SpringBasic.Utilities;

import com.ea.SpringBasic.models.Guide;
import com.ea.SpringBasic.models.Prospect;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Util {


    private String validPhoneNumbers[] = {"+13213073000", "+13213073001", "+13213073002", "+13213073003", "+13213073004"};


    public static String generateRandomString(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomEmail(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString() + "@test.com";
    }

    private static String generateRandomInt(int length) {
        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length); // bound is exclusive

        Random random = new Random();

        return Integer.toString(random.nextInt(max - min) + min);
    }

    private List<String> generateRandomGuideStatements() {

        List<String> numbers = new ArrayList<>();

        Random random = new Random();

        int min = 1;
        int max = 5;

        for (int i = 0; i <= 6 ; i++) {
            numbers.add(String.valueOf(random.nextInt((max-min) + 1 ) + min));
        }

        return numbers;

    }

    private static String generateRandomProspectStatements() {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<4; i++) {
            list.add(i);
        }
        return list.get(0)+", "+ list.get(1) +", " + list.get(2);
    }

    public String generatePhoneNumber(){

        String firstPart = "13213073";

        String secondPart = generateRandomInt(3);

        return firstPart.concat(secondPart);

    }

    private String getRandomAcademicStanding() {

        List<String> academicStandings = new ArrayList<>(Arrays.asList("FRESHMAN", "SOPHOMORE", "JUNIOR", "SENIOR", "GRAD_STUDENT"));

        Random random = new Random();

        int min = 1;
        int max = 5;

        return academicStandings.get(random.nextInt(max - min) + min);

    }

    public Prospect getRandomProspectWithStatements(){

        String name = generateRandomString(7);
        String phoneNumber = generatePhoneNumber();
        String major = generateRandomString(3);
        String statements = generateRandomProspectStatements();
        String termsAccepted = "yes";

        return new Prospect(name,phoneNumber,major,statements,termsAccepted);
        
    }

    public Guide getRandomGuide(){

        String type = "REGULAR";
        String firstName = generateRandomString(5);
        String lastName = generateRandomString(3);
        String email = generateRandomEmail(10);
        String phoneNumber = generatePhoneNumber();
        boolean undecided = false;
        String academicStanding = getRandomAcademicStanding();
        String major = generateRandomString(5);
        String paymentType = "Paypal";
        String paymentAddress = generateRandomString(5);
        List<String> statements = generateRandomGuideStatements();
        String introText = generateRandomString(15);


        return new Guide(type,firstName,lastName,email,phoneNumber, false,academicStanding,major,paymentType,paymentAddress,statements,introText,false);

    }


}
