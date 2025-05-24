package dk.sdu.cbse.scoringapi;

import dk.sdu.cbse.common.scoring.IScoringSPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ScoringAPI implements IScoringSPI {
    RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080/score?point=";

    @Override
    public int updateScore(int points) {
        ResponseEntity<String> response = restTemplate.getForEntity(url + points, String.class);
        if (response.getBody() == null) return -1;
        try {
            return Integer.parseInt(response.getBody());
        } catch(NumberFormatException e){
            System.out.println("Could not parse response as int");
            return -1;
        }
    }
}
