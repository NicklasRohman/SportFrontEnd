package backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.sportsing.api.Match;

@Named
@ViewScoped
public class SportsingBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Match>matchResults;
	
	public List<Match> getMatchResult(){
		matchResults = new ArrayList<>();
		WebTarget matchTarget = ClientBuilder.newClient()
				.target("http://localhost:8080/sportsing-webservice/rs/sports/list");	
		matchResults = matchTarget.request(MediaType.APPLICATION_XML).get(Match.class).getMatches();
	return matchResults;
	
	}

	public void setMatchResult(List<Match> matchResults) {
		this.matchResults = matchResults;
	}
	
}