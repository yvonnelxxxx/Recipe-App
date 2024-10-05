/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yvonne.computerscienceia;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.Paragraph;

/**
 *
 * @author student
 */
public class mealPlans {

    private String[][] mealP = new String[3][5];
    
    public String recAddMP(String[][] array, int r, int c, String content, int i) {
        String[] meal = {"Lunch","Dinner",""};
        if (r >= array.length) {
            return content;
        }
        content += array[r][c] + "\n";
        if (c < array[r].length - 1) {
            return recAddMP(array, r, c + 1, content,i);
        } else {
            content+="\n"+meal[i];
            content += "\n";
            return recAddMP(array, r + 1, 0, content,i+1);
        }
    }
    private String[][] apiData(String[][] mP, int mealN) throws ParseException {
        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/random.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                String responseData = response.toString();
                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = (JSONObject) parser.parse(responseData);
                JSONArray mealsArray = (JSONArray) jsonResponse.get("meals");
                JSONObject meal = (JSONObject) mealsArray.get(0);
                String mealName = (String) meal.get("strMeal");
                String mealCategory = (String) meal.get("strCategory");
                String mealArea = (String) meal.get("strArea");
                String mealInstructions = (String) meal.get("strInstructions");
                mP[mealN][0] = mealName;
                mP[mealN][1] = mealCategory;
                mP[mealN][2] = mealArea;
                mP[mealN][3] = mealInstructions;
                String ingredientS = "";
                for (int i = 1; i <= 20; i++) {
                    String ingredientKey = "strIngredient" + i;
                    String measureKey = "strMeasure" + i;
                    String ingredient = (String) meal.get(ingredientKey);
                    String measure = (String) meal.get(measureKey);

                    if (ingredient != null && !ingredient.isEmpty()) {
                        ingredientS = ingredientS + ingredient + ": " + measure;
                    }
                }
                mP[mealN][4] = ingredientS;
                return mP;
            } else {
                System.out.println("Error: " + responseCode);
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void generateDayMealPlan() throws ParseException {
        
        for (int i = 0; i < 3; i++) {
            mealP = apiData(mealP, i);
        }
        
        
        String filename = "/Users/student/Desktop/MealPlan.pdf";
        String content = "Breakfast\n";
        content = recAddMP(mealP, 0, 0, content,0);
        
        System.out.println(content);
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(filename));
            Document document = new Document(pdfDoc);
            Paragraph paragraph = new Paragraph(content);
            
            document.add(paragraph);
            document.close();
            System.out.println("PDF file generated successfully.");
        } catch (Exception e) {
            System.out.println("Error generating PDF: " + e.getMessage());
        }
    }
    
    public void main() throws ParseException{
        generateDayMealPlan();
    }

}
