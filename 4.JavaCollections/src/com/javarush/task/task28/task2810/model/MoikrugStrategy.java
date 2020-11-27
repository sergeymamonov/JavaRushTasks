package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();

        int i = 0;
        Document doc;
        try {
            while (true) {

                doc = getDocument(searchString, i++);
                if (doc == null) {
                    break;
                }

                Elements elements = doc.getElementsByAttributeValue("class", "job");
                elements.addAll( doc.getElementsByAttributeValue("class", "job marked"));

                if (elements.size()==0) break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByClass("title").first().text().trim());
                    vacancy.setSalary(element.getElementsByClass("salary").first().text().trim());
                    vacancy.setCity(element.select("span[class=location]").text().trim());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancy.setUrl("https://moikrug.ru" + element.select("div[class=title]").first().getElementsByTag("a").attr("href").trim());
                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36").referrer("no-referrer-when-downgrade").get();
    }
}
