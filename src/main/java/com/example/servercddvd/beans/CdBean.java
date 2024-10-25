package com.example.servercddvd.beans;


import com.example.servercddvd.model.Cd;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class CdBean {

    private List<Cd> cds = new ArrayList<>();

    @PostConstruct
    public void init() {
        try {
            String apiUrl = "http://localhost:8080/cds/disponibles";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            cds = mapper.readValue(response.toString(), new TypeReference<List<Cd>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cd> getCds() {
        return cds;
    }

    public void setCds(List<Cd> cds) {
        this.cds = cds;
    }
}

